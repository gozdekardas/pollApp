package com.pollapp.model;

import com.pollapp.model.Question;

import javax.persistence.*;

@Entity
@Table(name = "xx_responses")
public class Response {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RES_SEQ")
    @SequenceGenerator(sequenceName = "xx_responses_seq", allocationSize = 1, name = "RES_SEQ")
    private int responseId;
    private int questionId;
    private String responseText;
    private String createdBy;
    private String enabled;
    private int answered;


    @ManyToOne
    @JoinColumn(name = "questionId", insertable = false, updatable = false)
    private Question question;

    public int getResponseId() {
        return responseId;
    }

    public void setResponseId(int responseId) {
        this.responseId = responseId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getResponseText() {
        return responseText;
    }

    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public int getAnswered() {
        return answered;
    }

    public void setAnswered(int answered) {
        this.answered = answered;
    }


}
