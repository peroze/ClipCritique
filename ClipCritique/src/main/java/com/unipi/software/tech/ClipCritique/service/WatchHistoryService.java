package com.unipi.software.tech.ClipCritique.service;

import com.unipi.software.tech.ClipCritique.model.VideoCategory;
import com.unipi.software.tech.ClipCritique.model.WatchHistory;
import com.unipi.software.tech.ClipCritique.model.User;
import com.unipi.software.tech.ClipCritique.model.Video;
import com.unipi.software.tech.ClipCritique.repository.WatchHistoryRepository;
import com.unipi.software.tech.ClipCritique.repository.UserRepository;
import com.unipi.software.tech.ClipCritique.repository.VideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WatchHistoryService {

    private final WatchHistoryRepository watchHistoryRepository;
    private final VideoRepository videoRepository;
    private final UserRepository userRepository;
    public WatchHistory addNewHistory(WatchHistory watchHistory) {

        Video video = videoRepository.findById(watchHistory.getVideo().getId())
                .orElseThrow(() -> new IllegalArgumentException("Video couldn't be found"));

        User user = userRepository.findById(watchHistory.getUser().getId())
                .orElseThrow(() -> new IllegalArgumentException("User couldn't be found"));
        List <WatchHistory> temp = watchHistoryRepository.findReviewsByVideoAndUserId(watchHistory.getVideo().getId(), watchHistory.getUser().getId());
        if (temp.isEmpty()) {
            WatchHistory createdWatchHistory = WatchHistory.builder()
                    .user(user)
                    .video(video)
                    .rating(watchHistory.getRating())
                    .text(watchHistory.getText())
                    .build();

            return watchHistoryRepository.save(createdWatchHistory);
        }
        return watchHistoryRepository.save(temp.get(0));
    }

    public List<WatchHistory> getAllReviewsByVideoId(Long id){
        return watchHistoryRepository.findReviewsByVideoId(id);
    }

    public void updateRating (Long Video, Long user, Integer rating){
        List <WatchHistory> temp = watchHistoryRepository.findReviewsByVideoAndUserId(Video, user);
        temp.get(0).setRating(rating);
        watchHistoryRepository.save(temp.get(0));
    }
}
