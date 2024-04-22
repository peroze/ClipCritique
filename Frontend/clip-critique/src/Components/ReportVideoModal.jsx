import Modal from 'react-bootstrap/Modal';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import React, { useState,useEffect } from 'react';
import VideoService from "../services/video.service.js";
import { toast } from 'react-toastify';


const ReportVideoModal = ({ video, showModal, closeModal}) => {


    const applyChanges = () =>{
        VideoService.deleteVideo(video.id)
            .then((response) => {
                toast.success("The video was reported successfully.")
            })
            .catch(error => {
                toast.error("An error occurred. Please try again later.")
                console.log(error);
            })
            .finally( () => {
                closeModal();
            })
    }



    return (
        <Modal 
            show={showModal} 
            onHide={closeModal}
            backdrop="static" 
            centered
            
        >
            <Modal.Header closeButton>
                <Modal.Title id="contained-modal-title-vcenter">
                    Report Video
                </Modal.Title>
            </Modal.Header>
            <Modal.Body>
                <div>
                    Are you sure you want to report this video?
                </div>
                
            </Modal.Body>
            <Modal.Footer>
                <Button variant="danger" onClick={applyChanges}>Yes</Button>
                <Button onClick={closeModal}>No</Button>
            </Modal.Footer>
        </Modal>
    );
};

export default ReportVideoModal;