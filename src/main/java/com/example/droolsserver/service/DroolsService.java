package com.example.droolsserver.service;

import com.example.droolsserver.model.*;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class DroolsService {

    @Autowired
    private KieSession kieSession;

    public CuadroClinico procesarPaciente(Patient patient, List<QuestionnaireResponse> responses) {
        KieSession session = kieSession;
        try {
            // Insertar el paciente
            session.insert(patient);
            
            // Insertar las respuestas del cuestionario
            for (QuestionnaireResponse response : responses) {
                session.insert(response);
            }
            
            // Ejecutar las reglas
            session.fireAllRules();
            
            // Obtener el cuadro clínico resultante
            List<CuadroClinico> cuadros = new ArrayList<>();
            session.getObjects().forEach(obj -> {
                if (obj instanceof CuadroClinico) {
                    cuadros.add((CuadroClinico) obj);
                }
            });
            
            return cuadros.isEmpty() ? new CuadroClinico(patient.getId()) : cuadros.get(0);
        } finally {
            session.dispose();
        }
    }

    public List<Object> obtenerResultadosCompletos(Patient patient, List<QuestionnaireResponse> responses) {
        KieSession session = kieSession;
        List<Object> resultados = new ArrayList<>();
        
        try {
            // Insertar el paciente
            session.insert(patient);
            
            // Insertar las respuestas del cuestionario
            for (QuestionnaireResponse response : responses) {
                session.insert(response);
            }
            
            // Ejecutar las reglas
            session.fireAllRules();
            
            // Recopilar todos los resultados
            session.getObjects().forEach(obj -> {
                if (obj instanceof CuadroClinico || 
                    obj instanceof DiagnosticoTemprano || 
                    obj instanceof GenerarOrden || 
                    obj instanceof InformarWeb ||
                    obj instanceof Recommendation) {
                    resultados.add(obj);
                }
            });
            
        } finally {
            session.dispose();
        }
        
        return resultados;
    }

    public DiagnosticoTemprano obtenerDiagnostico(Patient patient, List<QuestionnaireResponse> responses) {
        KieSession session = kieSession;
        try {
            session.insert(patient);
            for (QuestionnaireResponse response : responses) {
                session.insert(response);
            }
            session.fireAllRules();
            
            List<DiagnosticoTemprano> diagnosticos = new ArrayList<>();
            session.getObjects().forEach(obj -> {
                if (obj instanceof DiagnosticoTemprano) {
                    diagnosticos.add((DiagnosticoTemprano) obj);
                }
            });
            
            return diagnosticos.isEmpty() ? null : diagnosticos.get(0);
        } finally {
            session.dispose();
        }
    }

    public GenerarOrden obtenerOrdenes(Patient patient, List<QuestionnaireResponse> responses) {
        KieSession session = kieSession;
        try {
            session.insert(patient);
            for (QuestionnaireResponse response : responses) {
                session.insert(response);
            }
            session.fireAllRules();
            
            List<GenerarOrden> ordenes = new ArrayList<>();
            session.getObjects().forEach(obj -> {
                if (obj instanceof GenerarOrden) {
                    ordenes.add((GenerarOrden) obj);
                }
            });
            
            return ordenes.isEmpty() ? null : ordenes.get(0);
        } finally {
            session.dispose();
        }
    }
}
