package com.pollapp.controller;


import com.pollapp.model.Question;
import com.pollapp.model.Response;
import com.pollapp.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ResponseController {

    @Autowired
    ResponseService responseService;

    @GetMapping("/responses")
    List<Response> all() {
        return responseService.listAllResponses();
    }

    @PostMapping("/response")
    public ResponseEntity<String> add(@RequestBody Response response) {
        responseService.saveResponse(response);
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/responses/{questionId}")
    List<Response> retrieveResponse(@PathVariable int questionId) {
        return responseService.findByQuestionId(questionId);
    }

    @PostMapping("/voteResponse/{responseId}")
    public ResponseEntity<String> add(@PathVariable  int responseId) {
        Response response = responseService.findByResponseId(responseId);
        response.setAnswered(response.getAnswered()+1);
        responseService.saveResponse(response);
        return ResponseEntity.ok("ok");
    }

}
