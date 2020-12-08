package com.pollapp.pollApp.question.service;
import com.pollapp.pollApp.question.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.pollapp.pollApp.question.model.Question;

import java.util.List;

@Service
@Transactional
public class QuestionService {
    @Autowired
    private QuestionRepository repo;

    public List<Question> listAllQuestions() {
        return repo.findAll();
    }

    public void saveQuestion(Question question) {
        repo.save(question);
    }

    public void deleteQuestion(Integer questionId) {
        repo.deleteById(questionId);
    }



}
