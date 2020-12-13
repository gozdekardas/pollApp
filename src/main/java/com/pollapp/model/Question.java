package com.pollapp.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "xx_questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QUE_SEQ")
    @SequenceGenerator(sequenceName = "xx_questions_seq", allocationSize = 1, name = "QUE_SEQ")
    private int questionId;
    private String questionText;
    private String createdBy;
    private String enabled;

    @OneToMany(mappedBy = "question",cascade = {CascadeType.ALL})
    private List<Response> responses;

    public List<Response> getResponses() {
        return responses;
    }

    public void setResponses(List<Response> responses) {
        this.responses = responses;
    }

    public int getQuestionId() {
        return questionId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }
}
