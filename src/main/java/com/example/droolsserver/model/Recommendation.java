package com.example.droolsserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Recommendation {
    
    @JsonProperty("testType")
    private String testType;
    
    @JsonProperty("confidence")
    private String confidence;
    
    @JsonProperty("message")
    private String message;
    
    @JsonProperty("score")
    private double score;
    
    @JsonProperty("criticalSymptoms")
    private int criticalSymptoms;
    
    @JsonProperty("reasoning")
    private List<String> reasoning;
    
    @JsonProperty("riskFactors")
    private List<String> riskFactors;
    
    @JsonProperty("estudiosRecomendados")
    private List<String> estudiosRecomendados;
    
    @JsonProperty("medicamentosContraproducentes")
    private List<String> medicamentosContraproducentes;
    
    @JsonProperty("tipoPorfiria")
    private String tipoPorfiria;
    
    @JsonProperty("cuadroClinico")
    private CuadroClinico cuadroClinico;

    // Constructores
    public Recommendation() {}

    // Getters y Setters
    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }

    public String getConfidence() {
        return confidence;
    }

    public void setConfidence(String confidence) {
        this.confidence = confidence;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getCriticalSymptoms() {
        return criticalSymptoms;
    }

    public void setCriticalSymptoms(int criticalSymptoms) {
        this.criticalSymptoms = criticalSymptoms;
    }

    public List<String> getReasoning() {
        return reasoning;
    }

    public void setReasoning(List<String> reasoning) {
        this.reasoning = reasoning;
    }

    public List<String> getRiskFactors() {
        return riskFactors;
    }

    public void setRiskFactors(List<String> riskFactors) {
        this.riskFactors = riskFactors;
    }

    public List<String> getEstudiosRecomendados() {
        return estudiosRecomendados;
    }

    public void setEstudiosRecomendados(List<String> estudiosRecomendados) {
        this.estudiosRecomendados = estudiosRecomendados;
    }

    public List<String> getMedicamentosContraproducentes() {
        return medicamentosContraproducentes;
    }

    public void setMedicamentosContraproducentes(List<String> medicamentosContraproducentes) {
        this.medicamentosContraproducentes = medicamentosContraproducentes;
    }

    public String getTipoPorfiria() {
        return tipoPorfiria;
    }

    public void setTipoPorfiria(String tipoPorfiria) {
        this.tipoPorfiria = tipoPorfiria;
    }

    public CuadroClinico getCuadroClinico() {
        return cuadroClinico;
    }

    public void setCuadroClinico(CuadroClinico cuadroClinico) {
        this.cuadroClinico = cuadroClinico;
    }

    @Override
    public String toString() {
        return "Recommendation{" +
                "testType='" + testType + '\'' +
                ", confidence='" + confidence + '\'' +
                ", message='" + message + '\'' +
                ", score=" + score +
                ", criticalSymptoms=" + criticalSymptoms +
                ", reasoning=" + reasoning +
                ", riskFactors=" + riskFactors +
                ", estudiosRecomendados=" + estudiosRecomendados +
                ", medicamentosContraproducentes=" + medicamentosContraproducentes +
                ", tipoPorfiria='" + tipoPorfiria + '\'' +
                ", cuadroClinico=" + cuadroClinico +
                '}';
    }
}
