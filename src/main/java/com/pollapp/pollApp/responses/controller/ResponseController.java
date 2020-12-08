package com.pollapp.pollApp.responses.controller;


import com.pollapp.pollApp.responses.model.Response;
import com.pollapp.pollApp.responses.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ResponseController {

    @Autowired
    ResponseService responseService;

    @GetMapping("/responses")
    List<Response> all() {
        return responseService.listAllResponses();
    }

    @PostMapping("/response")
    public void add(@RequestBody Response response) {
        responseService.saveResponse(response);
    }

    @GetMapping("/responses/{questionId}")
    List<Response> retrieveResponse(@PathVariable int questionId) {
        return responseService.findByQuestionId(questionId);
    }

}
