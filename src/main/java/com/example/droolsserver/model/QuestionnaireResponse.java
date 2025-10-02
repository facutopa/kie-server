package com.example.droolsserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public class QuestionnaireResponse {
    
    @JsonProperty("questionId")
    private String questionId;
    
    @JsonProperty("answer")
    private String answer;
    
    @JsonProperty("patientId")
    private String patientId;
    
    @JsonProperty("timestamp")
    private Date timestamp;

    // Constructores
    public QuestionnaireResponse() {}

    public QuestionnaireResponse(String questionId, String answer, String patientId) {
        this.questionId = questionId;
        this.answer = answer;
        this.patientId = patientId;
        this.timestamp = new Date();
    }

    // Getters y Setters
    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "QuestionnaireResponse{" +
                "questionId='" + questionId + '\'' +
                ", answer='" + answer + '\'' +
                ", patientId='" + patientId + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
