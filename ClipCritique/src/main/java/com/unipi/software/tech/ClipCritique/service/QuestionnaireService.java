package com.unipi.software.tech.ClipCritique.service;

import com.unipi.software.tech.ClipCritique.model.Questionnaire;
import com.unipi.software.tech.ClipCritique.model.User;
import com.unipi.software.tech.ClipCritique.model.secondary.QuestionnaireRequest;
import com.unipi.software.tech.ClipCritique.repository.QuestionnaireRepository;
import com.unipi.software.tech.ClipCritique.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionnaireService {

    private final UserRepository userRepository;
    private final QuestionnaireRepository questionnaireRepository;

    public List<Questionnaire> getQuestionnaireByUserId(Long id) {
        return questionnaireRepository.findQuestionnaireByUserId(id);
    }

    public Questionnaire AddQuestionnaire(QuestionnaireRequest Request) {
        User user = userRepository.findById(Request.getUser())
                .orElseThrow(() -> new IllegalArgumentException("User couldn't be found"));
        Questionnaire questionnaire = new Questionnaire(Request.getCategory1(), Request.getCategory2(), Request.getCategory3(), Request.getPrefer_songs1(), Request.getPrefer_songs2(), Request.getPrefer_songs3(), user);
        return questionnaireRepository.save(questionnaire);
    }

}
