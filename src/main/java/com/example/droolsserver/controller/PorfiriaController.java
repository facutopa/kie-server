package com.example.droolsserver.controller;

import com.example.droolsserver.model.*;
import com.example.droolsserver.service.DroolsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/porfiria")
@CrossOrigin(origins = "*")
public class PorfiriaController {

    @Autowired
    private DroolsService droolsService;

    @PostMapping("/evaluar")
    public ResponseEntity<Map<String, Object>> evaluarPaciente(
            @RequestBody Map<String, Object> request) {
        try {
            // Extraer datos del request
            Patient patient = new Patient();
            patient.setId((String) request.get("patientId"));
            patient.setFirstName((String) request.get("firstName"));
            patient.setLastName((String) request.get("lastName"));
            patient.setDni((String) request.get("dni"));
            patient.setAge((Integer) request.get("age"));
            patient.setGender((String) request.get("gender"));
            patient.setFamilyHistory((Boolean) request.get("familyHistory"));
            patient.setAlcoholConsumption((Boolean) request.get("alcoholConsumption"));
            patient.setFastingStatus((Boolean) request.get("fastingStatus"));

            // Crear respuestas del cuestionario
            @SuppressWarnings("unchecked")
            List<Map<String, Object>> responsesData = (List<Map<String, Object>>) request.get("responses");
            List<QuestionnaireResponse> responses = new ArrayList<>();
            
            if (responsesData != null) {
                for (Map<String, Object> responseData : responsesData) {
                    QuestionnaireResponse response = new QuestionnaireResponse();
                    response.setQuestionId((String) responseData.get("questionId"));
                    response.setAnswer((String) responseData.get("answer"));
                    response.setPatientId((String) responseData.get("patientId"));
                    responses.add(response);
                }
            }

            // Procesar con Drools
            List<Object> resultados = droolsService.obtenerResultadosCompletos(patient, responses);

            // Organizar resultados
            Map<String, Object> response = new HashMap<>();
            for (Object resultado : resultados) {
                if (resultado instanceof CuadroClinico) {
                    response.put("cuadroClinico", resultado);
                } else if (resultado instanceof DiagnosticoTemprano) {
                    response.put("diagnostico", resultado);
                } else if (resultado instanceof GenerarOrden) {
                    response.put("ordenes", resultado);
                } else if (resultado instanceof InformarWeb) {
                    response.put("medicamentos", resultado);
                }
            }

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/cuadro-clinico")
    public ResponseEntity<CuadroClinico> obtenerCuadroClinico(
            @RequestBody Map<String, Object> request) {
        try {
            Patient patient = new Patient();
            patient.setId((String) request.get("patientId"));
            patient.setFirstName((String) request.get("firstName"));
            patient.setLastName((String) request.get("lastName"));
            patient.setDni((String) request.get("dni"));
            patient.setAge((Integer) request.get("age"));
            patient.setGender((String) request.get("gender"));

            @SuppressWarnings("unchecked")
            List<Map<String, Object>> responsesData = (List<Map<String, Object>>) request.get("responses");
            List<QuestionnaireResponse> responses = new ArrayList<>();
            
            if (responsesData != null) {
                for (Map<String, Object> responseData : responsesData) {
                    QuestionnaireResponse response = new QuestionnaireResponse();
                    response.setQuestionId((String) responseData.get("questionId"));
                    response.setAnswer((String) responseData.get("answer"));
                    response.setPatientId((String) responseData.get("patientId"));
                    responses.add(response);
                }
            }

            CuadroClinico cuadro = droolsService.procesarPaciente(patient, responses);
            return ResponseEntity.ok(cuadro);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/diagnostico")
    public ResponseEntity<DiagnosticoTemprano> obtenerDiagnostico(
            @RequestBody Map<String, Object> request) {
        try {
            Patient patient = new Patient();
            patient.setId((String) request.get("patientId"));
            patient.setFirstName((String) request.get("firstName"));
            patient.setLastName((String) request.get("lastName"));
            patient.setDni((String) request.get("dni"));
            patient.setAge((Integer) request.get("age"));
            patient.setGender((String) request.get("gender"));

            @SuppressWarnings("unchecked")
            List<Map<String, Object>> responsesData = (List<Map<String, Object>>) request.get("responses");
            List<QuestionnaireResponse> responses = new ArrayList<>();
            
            if (responsesData != null) {
                for (Map<String, Object> responseData : responsesData) {
                    QuestionnaireResponse response = new QuestionnaireResponse();
                    response.setQuestionId((String) responseData.get("questionId"));
                    response.setAnswer((String) responseData.get("answer"));
                    response.setPatientId((String) responseData.get("patientId"));
                    responses.add(response);
                }
            }

            DiagnosticoTemprano diagnostico = droolsService.obtenerDiagnostico(patient, responses);
            return ResponseEntity.ok(diagnostico);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/ordenes")
    public ResponseEntity<GenerarOrden> obtenerOrdenes(
            @RequestBody Map<String, Object> request) {
        try {
            Patient patient = new Patient();
            patient.setId((String) request.get("patientId"));
            patient.setFirstName((String) request.get("firstName"));
            patient.setLastName((String) request.get("lastName"));
            patient.setDni((String) request.get("dni"));
            patient.setAge((Integer) request.get("age"));
            patient.setGender((String) request.get("gender"));

            @SuppressWarnings("unchecked")
            List<Map<String, Object>> responsesData = (List<Map<String, Object>>) request.get("responses");
            List<QuestionnaireResponse> responses = new ArrayList<>();
            
            if (responsesData != null) {
                for (Map<String, Object> responseData : responsesData) {
                    QuestionnaireResponse response = new QuestionnaireResponse();
                    response.setQuestionId((String) responseData.get("questionId"));
                    response.setAnswer((String) responseData.get("answer"));
                    response.setPatientId((String) responseData.get("patientId"));
                    responses.add(response);
                }
            }

            GenerarOrden ordenes = droolsService.obtenerOrdenes(patient, responses);
            return ResponseEntity.ok(ordenes);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("Sistema de Diagnóstico de Porfiria está funcionando correctamente");
    }

    @PostMapping("/test")
    public ResponseEntity<Map<String, Object>> testEndpoint(@RequestBody Map<String, Object> request) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Endpoint funcionando correctamente");
        response.put("receivedData", request);
        response.put("timestamp", new java.util.Date());
        return ResponseEntity.ok(response);
    }
}
