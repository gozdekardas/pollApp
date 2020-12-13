package com.pollapp.service;
import com.pollapp.model.Response;
import com.pollapp.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.pollapp.model.Question;

import java.util.List;

@Service
@Transactional
public class QuestionService {
    @Autowired
    private QuestionRepository repo;
    private ResponseService repoResp;

    public List<Question> listAllQuestions() {
        return repo.findAll();
    }

    public int saveQuestion(Question question) {
        repo.save(question);
        return question.getQuestionId();
    }

    public void deleteQuestion(Integer questionId) {
        repo.deleteById(questionId);
    }

    public Question findByQuestionId (int questionId) {
        return repo.findByQuestionId(questionId);
    }




}
