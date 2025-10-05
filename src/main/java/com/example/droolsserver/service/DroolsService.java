package com.example.droolsserver.service;

import com.example.droolsserver.model.*;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.KieContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class DroolsService {

    @Autowired
    private KieContainer kieContainer;

    public CuadroClinico procesarPaciente(Patient patient, List<QuestionnaireResponse> responses) {
        KieSession session = kieContainer.newKieSession();
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
        System.out.println("=== INICIANDO PROCESAMIENTO DROOLS ===");
        KieSession session = kieContainer.newKieSession();
        List<Object> resultados = new ArrayList<>();
        
        try {
            System.out.println("Paciente: " + patient);
            System.out.println("Respuestas: " + responses.size());
            
            // Insertar el paciente
            session.insert(patient);
            System.out.println("Paciente insertado en la sesión");
            
            // Insertar las respuestas del cuestionario
            for (QuestionnaireResponse response : responses) {
                session.insert(response);
                System.out.println("Respuesta insertada: " + response.getQuestionId() + " = " + response.getAnswer());
            }
            
            // Ejecutar las reglas
            System.out.println("Ejecutando reglas...");
            int rulesFired = session.fireAllRules();
            System.out.println("Reglas ejecutadas: " + rulesFired);
            
            // Recopilar todos los resultados
            System.out.println("Objetos en la sesión: " + session.getObjects().size());
            session.getObjects().forEach(obj -> {
                System.out.println("Objeto encontrado: " + obj.getClass().getSimpleName() + " = " + obj);
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
        
        System.out.println("Resultados finales: " + resultados.size());
        return resultados;
    }

    public DiagnosticoTemprano obtenerDiagnostico(Patient patient, List<QuestionnaireResponse> responses) {
        KieSession session = kieContainer.newKieSession();
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
        KieSession session = kieContainer.newKieSession();
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
