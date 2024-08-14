package com.unipi.software.tech.ClipCritique.repository;

import com.unipi.software.tech.ClipCritique.model.Questionnaire;
import com.unipi.software.tech.ClipCritique.model.Video;
import com.unipi.software.tech.ClipCritique.model.WatchHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionnaireRepository extends JpaRepository<Questionnaire, Long> {

    @Query("SELECT r FROM Questionnaire r WHERE r.uploader.id = :user_id")
    List<Questionnaire> findQuestionnaireByUserId(Long user_id);

}
