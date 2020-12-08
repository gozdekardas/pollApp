package com.pollapp.pollApp.question.controller;

import com.pollapp.pollApp.question.model.Question;
import com.pollapp.pollApp.question.service.QuestionService;
import com.pollapp.pollApp.responses.model.Response;
import com.pollapp.pollApp.responses.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
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
        for (int i = 0; i < questions.size(); i++) {
            System.out.println("i : " + i);
            System.out.println("que id : " + questions.get(i).getQuestionId());
            try {
                List<Response> responses = responseService.findByQuestionId(questions.get(i).getQuestionId());
                questions.get(i).setResponses(responses);
            } catch (Exception e) {
                System.out.println(e.getMessage());

            };

        }return questions;
    }

    @PostMapping("/addQuestion")
    public void add(@RequestBody Question question) {
        questionService.saveQuestion(question);
    }

}
