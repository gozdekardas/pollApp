package com.pollapp.pollApp.responses.repository;

import com.pollapp.pollApp.responses.model.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResponseRepository extends JpaRepository<Response, Integer> {
    List<Response> findByQuestionId(int questionId);

}
