package com.unipi.software.tech.ClipCritique.repository;

import com.unipi.software.tech.ClipCritique.model.WatchHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WatchHistoryRepository extends JpaRepository<WatchHistory, Long> {

    @Query("SELECT r FROM WatchHistory r WHERE r.video.id = :video_id")
    List<WatchHistory> findReviewsByVideoId(Long video_id);

    @Query("SELECT r FROM WatchHistory r WHERE r.video.id = :video_id AND r.user.id = :user_id")
    List<WatchHistory> findReviewsByVideoAndUserId(Long video_id, Long user_id);

}
