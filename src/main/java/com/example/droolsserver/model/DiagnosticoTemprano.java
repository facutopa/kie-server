package com.example.droolsserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DiagnosticoTemprano {
    
    @JsonProperty("patientId")
    private String patientId;
    
    @JsonProperty("sintomaCutanea")
    private String sintomaCutanea; // "Presenta", "No_Presenta", null
    
    @JsonProperty("sintomaAguda")
    private String sintomaAguda; // "Presenta", "No_Presenta", null

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

    public String getSintomaCutanea() {
        return sintomaCutanea;
    }

    public void setSintomaCutanea(String sintomaCutanea) {
        this.sintomaCutanea = sintomaCutanea;
    }

    public String getSintomaAguda() {
        return sintomaAguda;
    }

    public void setSintomaAguda(String sintomaAguda) {
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
