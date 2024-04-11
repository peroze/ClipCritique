package com.unipi.software.tech.ClipCritique.controller;

import com.unipi.software.tech.ClipCritique.model.Video;
import com.unipi.software.tech.ClipCritique.service.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "api/v1/video")
@RequiredArgsConstructor
public class VideoController {

    private final VideoService videoService;


    @GetMapping(path = "/")
    public ResponseEntity<List<Video>> getAllVideos() {
        try {
            List<Video> video =videoService.getAllVideos();
            return new ResponseEntity<>(video, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Video>> getVideoByid(@PathVariable("id") Long id ){
        try {
            return new ResponseEntity<>(videoService.getVideoById(id), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path="/")
    public ResponseEntity<Video> addNewVideo(@RequestBody Video video) {
        try {
            Video addedVideo=videoService.addNewVideo(video);
            return new ResponseEntity<>(addedVideo,HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path ="/{id}")
    public ResponseEntity<String> deleteVideoById(@PathVariable("id") Long id){
        try {
            videoService.deleteVideoById(id);
            return new ResponseEntity<>("Successfully Deleted Video ",HttpStatus.OK);
        }catch (IllegalStateException e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }


}
