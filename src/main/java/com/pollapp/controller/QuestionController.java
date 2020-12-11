package com.pollapp.controller;

import com.pollapp.model.Question;
import com.pollapp.service.QuestionService;
import com.pollapp.model.Response;
import com.pollapp.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuestionController {

    @Autowired
    QuestionService questionService;
    ResponseService responseService;

    @GetMapping("/questions")
    List<Question> all() {
        List<Question> questions = questionService.listAllQuestions();
        return questions;
    }

    @PostMapping("/addQuestion")
    public ResponseEntity<Question> add(@RequestBody Question question) {

        int questionId = questionService.saveQuestion(question);

        for (int i = 0; i < question.getResponses().size(); i++) {
            System.out.println(question.getResponses().get(i).getResponseText());
            try {
                question.getResponses().get(i).setQuestionId(questionId);
                System.out.println(i);
            } catch (Exception e) {
                System.out.println(e.getMessage());

            }
        }
        ;
        questionId = questionService.saveQuestion(question);
        return ResponseEntity.ok(
                question
        );
    }

}
