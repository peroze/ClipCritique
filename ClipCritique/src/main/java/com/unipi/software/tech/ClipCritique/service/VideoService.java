package com.unipi.software.tech.ClipCritique.service;

import com.unipi.software.tech.ClipCritique.model.Review;
import com.unipi.software.tech.ClipCritique.model.Video;
import com.unipi.software.tech.ClipCritique.repository.ReviewRepository;
import com.unipi.software.tech.ClipCritique.repository.VideoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VideoService {

    private final VideoRepository videoRepository;
    private final ReviewRepository reviewRepository;

    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }

    public Optional<Video> getVideoById(Long id){
        return videoRepository.findById(id);
    }

    public Video addNewVideo(Video video){
        Optional<Video> videoOptional = videoRepository.findByLink(video.getLink());
        if(videoOptional.isPresent()){
            throw new IllegalStateException("Video link already in the list");
        }
        Video createdVideo = new Video(video.getLink(),video.getUploader());
        return videoRepository.save(createdVideo);
    }

    public void deleteVideoById(Long id){
        boolean exists = videoRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Video with id "+id+" does not exist");
        }
        videoRepository.deleteById(id);
    }


    public double getAverageRating(Long id) {
        List<Review> reviews = reviewRepository.findReviewsByVideoId(id);
        if (reviews == null || reviews.isEmpty()) {
            return 0.0;
        }
        int totalRating = 0;
        for (Review review : reviews) {
            totalRating += review.getRating();
        }

        return (double) totalRating / reviews.size();

    }
}
