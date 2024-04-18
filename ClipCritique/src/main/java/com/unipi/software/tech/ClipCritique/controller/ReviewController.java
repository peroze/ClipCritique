package com.unipi.software.tech.ClipCritique.controller;

import com.unipi.software.tech.ClipCritique.model.Review;
import com.unipi.software.tech.ClipCritique.model.Video;
import com.unipi.software.tech.ClipCritique.service.ReviewService;
import com.unipi.software.tech.ClipCritique.service.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "api/v1/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping(path="/")
    public ResponseEntity<Review> addNewReview(@RequestBody Review review) {
        try {
            Review addedReview=reviewService.addNewReview(review);
            return new ResponseEntity<>(addedReview, HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path ="/all/{video_id}")
    public List<Review> findAllReviewsByVideoId(@PathVariable("video_id") Long video_id){
        return reviewService.getAllReviewsByVideoId(video_id);

    }

    @DeleteMapping(path ="/{id}")
    public ResponseEntity<Void> deleteReviewById(@PathVariable("id") Long id){
        reviewService.deleteReviewById(id);
        return ResponseEntity.noContent().build();
    }



}
