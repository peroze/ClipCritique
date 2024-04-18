package com.unipi.software.tech.ClipCritique.service;

import com.unipi.software.tech.ClipCritique.model.Review;
import com.unipi.software.tech.ClipCritique.model.User;
import com.unipi.software.tech.ClipCritique.model.Video;
import com.unipi.software.tech.ClipCritique.repository.ReviewRepository;
import com.unipi.software.tech.ClipCritique.repository.UserRepository;
import com.unipi.software.tech.ClipCritique.repository.VideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final VideoRepository videoRepository;
    private final UserRepository userRepository;
    public Review addNewReview(Review review) {

        Video video = videoRepository.findById(review.getVideo().getId())
                .orElseThrow(() -> new IllegalArgumentException("Video couldn't be found"));

        User user = userRepository.findById(review.getReviewer().getId())
                .orElseThrow(() -> new IllegalArgumentException("User couldn't be found"));

        Review createdReview = Review.builder()
                .reviewer(user)
                .video(video)
                .rating(review.getRating())
                .text(review.getText())
                .build();

        return reviewRepository.save(createdReview);
    }

    public List<Review> getAllReviewsByVideoId(Long id){
        return reviewRepository.findReviewsByVideoId(id);
    }

    public void deleteReviewById(Long id){
        boolean exists = reviewRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Review with id "+id+" does not exist");
        }
        reviewRepository.deleteById(id);
    }

}
