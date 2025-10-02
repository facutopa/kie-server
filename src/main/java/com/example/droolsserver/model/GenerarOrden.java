package com.example.droolsserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class GenerarOrden {
    
    @JsonProperty("patientId")
    private String patientId;
    
    @JsonProperty("estudios")
    private List<String> estudios;

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

    public List<String> getEstudios() {
        return estudios;
    }

    public void setEstudios(List<String> estudios) {
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
