import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import Offcanvas from'react-bootstrap/Offcanvas';
import "bootstrap/dist/css/bootstrap.min.css";
import "../App.css";
import logo from './Images/Steering.png';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import {faUser} from'@fortawesome/free-regular-svg-icons'
import {faFilm} from'@fortawesome/free-solid-svg-icons'
import Container from 'react-bootstrap/Container';import { Link } from 'react-router-dom';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom'; 

function MenuBar(){

    return (


    <Navbar expand="lg" fixed="top" variant="light" className="rounded-pill m-1 p-0 navbar" >
          <Container fluid>
            <Navbar.Brand className='me-auto' as={Link} to="/"><img width="150"  className="Navbarlogo" src={logo}></img></Navbar.Brand>
            <Navbar.Toggle  data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar" aria-controls="offcanvasNavbar"><FontAwesomeIcon className="burger" icon={faFilm}/></Navbar.Toggle>
            <Navbar.Offcanvas id="offcanvasNavbar" 
              placement='end'>
                <Offcanvas.Header closeButton>
                <Offcanvas.Title className='ctitle'>
                  ClipCritique
                </Offcanvas.Title>
              </Offcanvas.Header>
                <Offcanvas.Body className='m-3'>
                    <Nav className="ms-auto gap-4 offcanvas-body " id='offcanvasNavbar'>
                      <Nav.Link as={Link} to="/">Home</Nav.Link>
                      <Nav.Link as={Link} to="/" >Video List</Nav.Link>
                      <Nav.Link as={Link} to="/" >Contact Us</Nav.Link>
                    </Nav>
                </Offcanvas.Body>
            </Navbar.Offcanvas>
        </Container>
    </Navbar>
    )
}

export default MenuBar;




