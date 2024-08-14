package com.unipi.software.tech.ClipCritique.controller;

import com.unipi.software.tech.ClipCritique.model.Questionnaire;
import com.unipi.software.tech.ClipCritique.model.Video;
import com.unipi.software.tech.ClipCritique.model.secondary.QuestionnaireRequest;
import com.unipi.software.tech.ClipCritique.service.QuestionnaireService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "api/v1/questionnaire")
@RequiredArgsConstructor
public class QuestionnaireController {

    private final QuestionnaireService questionnaireService;

    @PostMapping(path = "/")
    public ResponseEntity<Questionnaire> addNewQuestionnaire(@RequestBody QuestionnaireRequest Request) {
        try {
            Questionnaire addedQuestionnaire = questionnaireService.AddQuestionnaire(Request);
            return new ResponseEntity<>(addedQuestionnaire, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<List<Questionnaire>> getQuestionnaireByUserId(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(questionnaireService.getQuestionnaireByUserId(id), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
