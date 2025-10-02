package com.example.droolsserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CuadroClinico {
    
    @JsonProperty("patientId")
    private String patientId;
    
    @JsonProperty("sintomasCutanea")
    private double sintomasCutanea;
    
    @JsonProperty("sintomasAguda")
    private double sintomasAguda;
    
    @JsonProperty("anamnesis")
    private double anamnesis;
    
    @JsonProperty("puntuacionTotal")
    private double puntuacionTotal;
    
    @JsonProperty("tipoPorfiria")
    private String tipoPorfiria; // "AGUDA", "CUTANEA", "MIXTA", "NO_APLICA"
    
    @JsonProperty("nivelRiesgo")
    private String nivelRiesgo; // "ALTO", "MEDIO", "BAJO"

    // Constructores
    public CuadroClinico() {}

    public CuadroClinico(String patientId) {
        this.patientId = patientId;
        this.sintomasCutanea = 0.0;
        this.sintomasAguda = 0.0;
        this.anamnesis = 0.0;
        this.puntuacionTotal = 0.0;
    }

    // Getters y Setters
    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public double getSintomasCutanea() {
        return sintomasCutanea;
    }

    public void setSintomasCutanea(double sintomasCutanea) {
        this.sintomasCutanea = sintomasCutanea;
    }

    public double getSintomasAguda() {
        return sintomasAguda;
    }

    public void setSintomasAguda(double sintomasAguda) {
        this.sintomasAguda = sintomasAguda;
    }

    public double getAnamnesis() {
        return anamnesis;
    }

    public void setAnamnesis(double anamnesis) {
        this.anamnesis = anamnesis;
    }

    public double getPuntuacionTotal() {
        return puntuacionTotal;
    }

    public void setPuntuacionTotal(double puntuacionTotal) {
        this.puntuacionTotal = puntuacionTotal;
    }

    public String getTipoPorfiria() {
        return tipoPorfiria;
    }

    public void setTipoPorfiria(String tipoPorfiria) {
        this.tipoPorfiria = tipoPorfiria;
    }

    public String getNivelRiesgo() {
        return nivelRiesgo;
    }

    public void setNivelRiesgo(String nivelRiesgo) {
        this.nivelRiesgo = nivelRiesgo;
    }

    @Override
    public String toString() {
        return "CuadroClinico{" +
                "patientId='" + patientId + '\'' +
                ", sintomasCutanea=" + sintomasCutanea +
                ", sintomasAguda=" + sintomasAguda +
                ", anamnesis=" + anamnesis +
                ", puntuacionTotal=" + puntuacionTotal +
                ", tipoPorfiria='" + tipoPorfiria + '\'' +
                ", nivelRiesgo='" + nivelRiesgo + '\'' +
                '}';
    }
}
