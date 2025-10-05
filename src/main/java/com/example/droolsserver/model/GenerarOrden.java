package com.example.droolsserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GenerarOrden {
    
    @JsonProperty("patientId")
    private String patientId;
    
    @JsonProperty("estudios")
    private Boolean estudios; // true si necesita estudios, false si no

    // Constructores
    public GenerarOrden() {}

    public GenerarOrden(String patientId) {
        this.patientId = patientId;
    }

    // Getters y Setters
    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public Boolean getEstudios() {
        return estudios;
    }

    public void setEstudios(Boolean estudios) {
        this.estudios = estudios;
    }

    @Override
    public String toString() {
        return "GenerarOrden{" +
                "patientId='" + patientId + '\'' +
                ", estudios=" + estudios +
                '}';
    }
}
