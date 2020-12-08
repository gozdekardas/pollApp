package com.pollapp.pollApp.responses.service;

import com.pollapp.pollApp.responses.model.Response;
import com.pollapp.pollApp.responses.repository.ResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ResponseService {
    @Autowired
    private ResponseRepository repo;

    public List<Response> listAllResponses() {
        return repo.findAll();
    }

    public void saveResponse(Response response) {
        repo.save(response);
    }

    public void deleteResponse(Integer responseId) {
        repo.deleteById(responseId);
    }

    public List<Response> findByQuestionId (int questionId) {
        return repo.findByQuestionId(questionId);
    }



}
