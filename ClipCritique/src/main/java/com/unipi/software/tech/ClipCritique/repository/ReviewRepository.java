package com.unipi.software.tech.ClipCritique.repository;

import com.unipi.software.tech.ClipCritique.model.Review;
import com.unipi.software.tech.ClipCritique.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query("SELECT r FROM Review r WHERE r.video.id = :video_id")
    List<Review> findReviewsByVideoId(Long video_id);



}
