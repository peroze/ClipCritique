package com.unipi.software.tech.ClipCritique.service;

import com.unipi.software.tech.ClipCritique.model.Video;
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
        Video createdVideo = new Video(video.getLink());
        return videoRepository.save(createdVideo);
    }

    public void deleteVideoById(Long id){
        boolean exists = videoRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Video with id "+id+" does not exist");
        }
        videoRepository.deleteById(id);
    }




}
