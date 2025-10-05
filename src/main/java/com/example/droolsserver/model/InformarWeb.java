package com.example.droolsserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InformarWeb {
    
    @JsonProperty("patientId")
    private String patientId;
    
    // Ya no se envía el detalle; la app cliente decide qué mostrar.
    
    @JsonProperty("medicamentos")
    private Boolean medicamentos; // true si necesita informar medicamentos, false si no

    // Constructores
    public InformarWeb() {}

    public InformarWeb(String patientId) {
        this.patientId = patientId;
    }

    // Getters y Setters
    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }


    public Boolean getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(Boolean medicamentos) {
        this.medicamentos = medicamentos;
    }

    @Override
    public String toString() {
        return "InformarWeb{" +
                "patientId='" + patientId + '\'' +
                '}';
    }
}
