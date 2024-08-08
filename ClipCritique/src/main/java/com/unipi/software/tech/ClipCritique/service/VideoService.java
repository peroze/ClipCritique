package com.unipi.software.tech.ClipCritique.service;

import com.unipi.software.tech.ClipCritique.model.WatchHistory;
import com.unipi.software.tech.ClipCritique.model.Video;
import com.unipi.software.tech.ClipCritique.repository.WatchHistoryRepository;
import com.unipi.software.tech.ClipCritique.repository.VideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.ssl.SslProperties;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VideoService {

    private final VideoRepository videoRepository;
    private final WatchHistoryRepository watchHistoryRepository;

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
        Video createdVideo = new Video(video.getLink(),video.getUploader(),video.getName(), video.getCategory(), video.getAgerating());
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
        Integer minus = 0;
        List<WatchHistory> watchHistories = watchHistoryRepository.findReviewsByVideoId(id);
        if (watchHistories == null || watchHistories.isEmpty()) {
            return 0.0;
        }
        int totalRating = 0;
        for (WatchHistory watchHistory : watchHistories) {
            if (watchHistory.getRating() == -1) {
                minus = minus +1;
                continue;
            }
            totalRating += watchHistory.getRating();
        }
        if (watchHistories.size() - minus == 0) {
            return 0.0;
        }
        return (double) totalRating / ( watchHistories.size() - minus);

    }
}
