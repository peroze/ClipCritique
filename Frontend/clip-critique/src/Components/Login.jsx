import React, { useState, useContext } from 'react';
import { Link } from 'react-router-dom';
import LoadingButton from './LoadingButton';
import Card from 'react-bootstrap/Card';
import {FaEyeSlash, FaEye} from 'react-icons/fa';

import Form from 'react-bootstrap/Form';
import InputGroup from 'react-bootstrap/InputGroup';
import Button from 'react-bootstrap/Button';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import AuthService from "../services/auth.service";
import UserService from "../services/user.service";
import { useNavigate } from 'react-router-dom';

import { useEffect } from 'react';
import { UserContext } from '../App';
import { toast } from 'react-toastify';

import './Style/Login.css'; // Import the external CSS file


const Login = () => {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [showPassword, setShowPassword] = useState(false);
    const [googleLogin, setGoogleLogin] = useState(false);
    const [isGoogleSignUp,setIsGoogleSignUp] = useState(false);
    const [googleProfileImage,setGoogleProfileImage] = useState("");

    const {isLoggedIn,setIsLoggedIn} = useContext(UserContext);
    const {user, setUser} = useContext(UserContext);

    const navigate = useNavigate();

    const handleButtonClick = async () => {
        try { 
            const response = await AuthService.login(email, password); // Wait for login to complete
            handleLogin();
            setIsLoggedIn(true);
            toast.success("Successful Login");
        } catch (error) {
            setIsLoggedIn(false);
            if (!error.response) {
                toast.error("No response from the server. Please try again later.");
                return;
            }
            if (error.response.status === 401) {
                toast.error("Invalid Credentials");
            }
            else {
                toast.error("An error occurred. Please try again later.");
            }
        }

    };

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        if (name === 'email') {
            setEmail(value);
        } else if (name === 'password') {
            setPassword(value);
        }
    };

    const handleLogin = async () => {
        try {
            const response = await UserService.getUserByEmail(email);
            await setUser(response);

            navigate("/");
        } catch (error) {
            console.log(error);
        }
    }



    return(
        <Container fluid className="login-page align-items-center justify-content-center">
            <Row className="login-row text-center d-flex w-100 align-items-center justify-content-center">
                <Col sm={12} lg={12} md={12} className="login-card-col d-flex align-items-center justify-content-center">
                   
                    
                    <Card fluid className= "login-card my-sm-3 my-md-5 flex-wrap">
                        <Card.Body className="p-sm-3 p-md-4">

                            <Row>
                                <Col className="text-center mb-4">
                                    <h1 className="login_title">Login to your account</h1>
                                    <p className="login_subtitle">Don't have an account? &nbsp;
                                        <Link to="/register">Register</Link>
                                    </p>
                                </Col>
                            </Row>
                            <Row className="justify-content-center">

                                            <Form className="p-4 p-sm-3" id="login-form">
                                            
                                                <Form.Group className="mb-3" controlId="formBasicEmail">
                                                <Form.Label>Email</Form.Label>
                                                    <Form.Control 
                                                        type="email"
                                                        className="custom-fields-2" 
                                                        placeholder="Enter email" 
                                                        name="email"
                                                        value={email}                                              
                                                        onChange={handleInputChange}                                                    
                                                    />
                                                    <Form.Text className="text-muted info-text">
                                                        We'll never share your email with anyone else.
                                                    </Form.Text>
                                                </Form.Group>
                                                       
                                                <Form.Group className="mb-3" controlId="formBasicPassword" >
                                                    <Form.Label>Password</Form.Label>
                                                    <InputGroup className="mb-3">
                                                        <Form.Control
                                                        type={showPassword ? "text" : "password"}
                                                        placeholder="Password"
                                                        className="custom-fields-2"
                                                        name="password"                                         
                                                        value={password}
                                                        onChange={handleInputChange}
                                                        />
                                                        <Button 
                                                            variant="outline-secondary" 
                                                            onClick={() => setShowPassword(!showPassword)}
                                                            className="custom-eye-Btn"                                          
                                                        >
                                                        {showPassword ? <FaEyeSlash /> : <FaEye />}
                                                        </Button>
                                                    </InputGroup>

                                                </Form.Group>

                                                <LoadingButton
                                                    name="Log in"    
                                                    loadingText="Logging in..."
                                                    onClick={handleButtonClick} 
                                                    className="custom-btn-2"                                      
                                                />
                                               
                                                
                    
                                            </Form>
                               
                            </Row>    
                                                  
                        </Card.Body>
        
                    </Card>
                    

                </Col>
            </Row>      
        </Container>
    )

}

export default Login;