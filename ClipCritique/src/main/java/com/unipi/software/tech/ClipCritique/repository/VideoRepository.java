package com.unipi.software.tech.ClipCritique.repository;

import com.unipi.software.tech.ClipCritique.model.Video;
import com.unipi.software.tech.ClipCritique.model.VideoCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {

    @Query("SELECT r FROM Video r WHERE r.id = 1 OR r.id = 2 OR r.id = 3 OR r.id = 4 OR r.id = 5 OR r.id = 6")
    List<Video> findquestionnaire();
    Optional<Video> findByLink(String link);

    @Query("SELECT r FROM Video r WHERE r.category = :category")
    List<Video> findByTheCategory(VideoCategory category);
}
