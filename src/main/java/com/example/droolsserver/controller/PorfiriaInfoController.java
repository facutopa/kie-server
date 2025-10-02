package com.example.droolsserver.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/porfiria")
@CrossOrigin(origins = "*")
public class PorfiriaInfoController {

    @GetMapping("/info")
    public ResponseEntity<Map<String, Object>> obtenerInfoReglas() {
        Map<String, Object> info = new HashMap<>();
        info.put("servidor", "Sistema de Diagnóstico de Porfiria");
        info.put("version", "1.0.0");
        info.put("descripcion", "Sistema de puntuación para diagnóstico de Porfiria basado en reglas médicas");
        info.put("reglasDisponibles", new String[]{
            "Reglas de síntomas cutáneos (12 reglas)",
            "Reglas de síntomas agudos (17 reglas)", 
            "Reglas de anamnesis (20 reglas)",
            "Reglas de diagnóstico temprano (4 reglas)",
            "Reglas de órdenes de estudios (2 reglas)",
            "Reglas de medicamentos contraproducentes (1 regla)"
        });
        info.put("endpoints", new String[]{
            "POST /api/porfiria/evaluar - Evaluación completa del paciente",
            "POST /api/porfiria/cuadro-clinico - Obtener cuadro clínico",
            "POST /api/porfiria/diagnostico - Obtener diagnóstico temprano",
            "POST /api/porfiria/ordenes - Obtener órdenes de estudios",
            "GET /api/porfiria/health - Estado del servidor",
            "GET /api/porfiria/ejemplos - Ejemplos de uso"
        });
        info.put("categoriasSintomas", new String[]{
            "Síntomas Cutáneos: Máculas, Fragilidad, Hipertricosis, Nódulos, etc.",
            "Síntomas Agudos: Trastornos Psiquiátricos, Parestesias, Cefaleas, Paresia, etc.",
            "Anamnesis: Color orina, Familiares, Diabetes, HTA, Tiroides, etc."
        });
        return ResponseEntity.ok(info);
    }

    @GetMapping("/ejemplos")
    public ResponseEntity<Map<String, Object>> obtenerEjemplos() {
        Map<String, Object> ejemplos = new HashMap<>();
        
        // Ejemplo de paciente
        Map<String, Object> pacienteEjemplo = new HashMap<>();
        pacienteEjemplo.put("patientId", "P001");
        pacienteEjemplo.put("firstName", "María");
        pacienteEjemplo.put("lastName", "González");
        pacienteEjemplo.put("dni", "12345678");
        pacienteEjemplo.put("age", 35);
        pacienteEjemplo.put("gender", "F");
        pacienteEjemplo.put("familyHistory", true);
        pacienteEjemplo.put("alcoholConsumption", false);
        pacienteEjemplo.put("fastingStatus", false);
        
        // Ejemplo de respuestas del cuestionario
        List<Map<String, Object>> respuestasEjemplo = new ArrayList<>();
        
        Map<String, Object> respuesta1 = new HashMap<>();
        respuesta1.put("questionId", "maculas");
        respuesta1.put("answer", "SI");
        respuesta1.put("patientId", "P001");
        respuestasEjemplo.add(respuesta1);
        
        Map<String, Object> respuesta2 = new HashMap<>();
        respuesta2.put("questionId", "fragilidadCutanea");
        respuesta2.put("answer", "SI");
        respuesta2.put("patientId", "P001");
        respuestasEjemplo.add(respuesta2);
        
        Map<String, Object> respuesta3 = new HashMap<>();
        respuesta3.put("questionId", "fotosensibilidad");
        respuesta3.put("answer", "SI");
        respuesta3.put("patientId", "P001");
        respuestasEjemplo.add(respuesta3);
        
        Map<String, Object> respuesta4 = new HashMap<>();
        respuesta4.put("questionId", "dolorAbdominalLumbar");
        respuesta4.put("answer", "SI");
        respuesta4.put("patientId", "P001");
        respuestasEjemplo.add(respuesta4);
        
        Map<String, Object> respuesta5 = new HashMap<>();
        respuesta5.put("questionId", "colorOrina");
        respuesta5.put("answer", "Oscura");
        respuesta5.put("patientId", "P001");
        respuestasEjemplo.add(respuesta5);
        
        Map<String, Object> respuesta6 = new HashMap<>();
        respuesta6.put("questionId", "familiares");
        respuesta6.put("answer", "SI");
        respuesta6.put("patientId", "P001");
        respuestasEjemplo.add(respuesta6);
        
        ejemplos.put("paciente", pacienteEjemplo);
        ejemplos.put("respuestas", respuestasEjemplo);
        
        // Ejemplo de request completo
        Map<String, Object> requestEjemplo = new HashMap<>();
        requestEjemplo.put("patientId", "P001");
        requestEjemplo.put("firstName", "María");
        requestEjemplo.put("lastName", "González");
        requestEjemplo.put("dni", "12345678");
        requestEjemplo.put("age", 35);
        requestEjemplo.put("gender", "F");
        requestEjemplo.put("familyHistory", true);
        requestEjemplo.put("alcoholConsumption", false);
        requestEjemplo.put("fastingStatus", false);
        requestEjemplo.put("responses", respuestasEjemplo);
        
        ejemplos.put("requestCompleto", requestEjemplo);
        
        return ResponseEntity.ok(ejemplos);
    }
}
