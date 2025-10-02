package com.example.droolsserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class InformarWeb {
    
    @JsonProperty("patientId")
    private String patientId;
    
    @JsonProperty("medicamentosContraproducentes")
    private List<String> medicamentosContraproducentes;

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

    public List<String> getMedicamentosContraproducentes() {
        return medicamentosContraproducentes;
    }

    public void setMedicamentosContraproducentes(List<String> medicamentosContraproducentes) {
        this.medicamentosContraproducentes = medicamentosContraproducentes;
    }

    @Override
    public String toString() {
        return "InformarWeb{" +
                "patientId='" + patientId + '\'' +
                ", medicamentosContraproducentes=" + medicamentosContraproducentes +
                '}';
    }
}
