package com.example.droolsserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DiagnosticoTemprano {
    
    @JsonProperty("patientId")
    private String patientId;
    
    @JsonProperty("sintomaCutanea")
    private Boolean sintomaCutanea; // true si presenta, false si no presenta, null si no evaluado
    
    @JsonProperty("sintomaAguda")
    private Boolean sintomaAguda; // true si presenta, false si no presenta, null si no evaluado

    // Constructores
    public DiagnosticoTemprano() {}

    public DiagnosticoTemprano(String patientId) {
        this.patientId = patientId;
    }

    // Getters y Setters
    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public Boolean getSintomaCutanea() {
        return sintomaCutanea;
    }

    public void setSintomaCutanea(Boolean sintomaCutanea) {
        this.sintomaCutanea = sintomaCutanea;
    }

    public Boolean getSintomaAguda() {
        return sintomaAguda;
    }

    public void setSintomaAguda(Boolean sintomaAguda) {
        this.sintomaAguda = sintomaAguda;
    }

    @Override
    public String toString() {
        return "DiagnosticoTemprano{" +
                "patientId='" + patientId + '\'' +
                ", sintomaCutanea='" + sintomaCutanea + '\'' +
                ", sintomaAguda='" + sintomaAguda + '\'' +
                '}';
    }
}
