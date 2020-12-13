package com.pollapp.repository;

import com.pollapp.model.Question;
import com.pollapp.model.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer>{

    Question findByQuestionId(int questionId);

}
