import React, { useState,useEffect } from 'react';
import { Link } from 'react-router-dom';
import Card from 'react-bootstrap/Card';
import Form from 'react-bootstrap/Form';
import InputGroup from 'react-bootstrap/InputGroup';
import Button from 'react-bootstrap/Button';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import LoadingButton from './LoadingButton';
import { useLocation } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';
import videoService from '../services/video.service';


function UploadVideo() {

const [videoname, setvideoname] = useState("");
const [videourl, setvideourl] = useState("");


const handleInputChange = (e) => {
    
    const { name, value } = e.target;
    if (name === 'videoname') {
      setvideoname(value);
    } else if (name === 'videourl') {
      setvideourl(value);
    }     
  }; 

  const handleButtonClick = () => {
    videoService.addvideo(videourl, new Date(), videoname, null)
  };

    return (
        <Container fluid className="addshowtime-page w-500 align-items-center justify-content-center">
          <Row className="addshowtime-row text-center d-flex w-500 align-items-center justify-content-center">
            <Col sm={12} lg={12} md={12} className="addshowtime-card-col d-flex align-items-center justify-content-center">
              <Card className= "addshowtime-card my-sm-3 my-md-4 flex-wrap">
                <Card.Body className="p-sm-3 p-md-4">
                <Row>
                    <Col className="text-center mb-1">
                      <h1>Upload Video</h1>
                    </Col>
                  </Row>
                  <Row>
                    <Form className="p-4 p-sm-0" id="addshowtime-form">
    
                                
                        <Form.Group className="mb-3 w-100" controlId="formDuration" >
                            <Form.Label>Video Name</Form.Label>
                            <InputGroup className="mb-3">
                            <Form.Control
                          id='name'
                          type="text"
                          className="custom-fields" 
                          placeholder="Video Name" 
                          name="videoname"
                          value={videoname}
                          onChange={handleInputChange}                                                    
                        />
                          
                      </InputGroup>
                        </Form.Group>

                        <Form.Group className="mb-3 w-100" controlId="formDuration" >
                            <Form.Label>Video Url</Form.Label>
                            <InputGroup className="mb-3">
                            <Form.Control
                          id='url'
                          type="text"
                          className="custom-fields" 
                          placeholder="Video Url" 
                          name="videourl"
                          value={videourl}
                          onChange={handleInputChange}                                                    
                        />
                          
                      </InputGroup>
                        </Form.Group>
        
                        <LoadingButton
                            name="Submit"    
                            loadingText="Submitting..."
                            onClick={handleButtonClick}                                                  
                        />
    
                    </Form>
                    
                  </Row>
                </Card.Body>
              </Card>
            </Col>
          </Row>
        </Container>
      );

} export default UploadVideo;