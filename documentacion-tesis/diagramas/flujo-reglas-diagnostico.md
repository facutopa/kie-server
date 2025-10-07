# Diagramas de Flujo del Sistema de Reglas

## Figura 6.10 - Flujo General del Sistema de Diagnóstico

```mermaid
flowchart TD
    A[Paciente ingresa al sistema] --> B[Inicializar Cuadro Clínico]
    B --> C[Evaluar Síntomas Cutáneos]
    B --> D[Evaluar Síntomas Agudos]
    B --> E[Evaluar Anamnesis]
    
    C --> C1[REG-001: Máculas +2]
    C --> C2[REG-002: Fragilidad Cutánea +5]
    C --> C3[REG-003: Hipertricosis +4]
    C --> C4[REG-010: Fotosensibilidad +5]
    C --> C5[REG-011: Pruritos +2]
    C --> C6[REG-012: Tricosis +3]
    
    D --> D1[REG-013: Trastornos Psiquiátricos +4]
    D --> D2[REG-014: Parestesias +5]
    D --> D3[REG-015: Cefaleas +3]
    D --> D4[REG-016: Paresia +5]
    D --> D5[REG-018: Trastornos Abdominales +5]
    D --> D6[REG-022: Estrés +5]
    
    E --> E1[REG-030: Color Orina Oscura +5]
    E --> E2[REG-031: Familiares +5]
    E --> E3[REG-032: Diabetes +0.5]
    E --> E4[REG-045: Consume Alcohol +5]
    E --> E5[REG-046: Fuma +2]
    
    C1 --> F[Acumular Puntuación Cutánea]
    C2 --> F
    C3 --> F
    C4 --> F
    C5 --> F
    C6 --> F
    
    D1 --> G[Acumular Puntuación Aguda]
    D2 --> G
    D3 --> G
    D4 --> G
    D5 --> G
    D6 --> G
    
    E1 --> H[Acumular Puntuación Anamnesis]
    E2 --> H
    E3 --> H
    E4 --> H
    E5 --> H
    
    F --> I{¿Puntuación Cutánea ≥ 22?}
    G --> J{¿Puntuación Aguda ≥ 36?}
    
    I -->|Sí| K[Diagnóstico: Sintomatología Cutánea]
    I -->|No| L[Sin sintomatología cutánea]
    
    J -->|Sí| M[Diagnóstico: Sintomatología Aguda]
    J -->|No| N[Sin sintomatología aguda]
    
    K --> O[Generar Orden de Estudios]
    M --> O
    O --> P[Informar Medicamentos Contraproducentes]
    P --> Q[Recomendaciones Finales]
    
    L --> R[Evaluación Completa]
    N --> R
    R --> Q
```

## Figura 6.11 - Flujo de Reglas de Síntomas Cutáneos

```mermaid
flowchart TD
    A[Inicio Evaluación Cutánea] --> B[REG-001: Máculas]
    B --> C{¿Presenta máculas?}
    C -->|Sí| D[+2 puntos]
    C -->|No| E[0 puntos]
    
    D --> F[REG-002: Fragilidad Cutánea]
    E --> F
    F --> G{¿Presenta fragilidad?}
    G -->|Sí| H[+5 puntos]
    G -->|No| I[0 puntos]
    
    H --> J[REG-010: Fotosensibilidad]
    I --> J
    J --> K{¿Presenta fotosensibilidad?}
    K -->|Sí| L[+5 puntos]
    K -->|No| M[0 puntos]
    
    L --> N[Acumular Total Cutáneo]
    M --> N
    N --> O{¿Total ≥ 22?}
    O -->|Sí| P[Diagnóstico Cutáneo Positivo]
    O -->|No| Q[Sin diagnóstico cutáneo]
```

## Figura 6.12 - Flujo de Reglas de Síntomas Agudos

```mermaid
flowchart TD
    A[Inicio Evaluación Aguda] --> B[REG-014: Parestesias]
    B --> C{¿Presenta parestesias?}
    C -->|Sí| D[+5 puntos]
    C -->|No| E[0 puntos]
    
    D --> F[REG-016: Paresia]
    E --> F
    F --> G{¿Presenta paresia?}
    G -->|Sí| H[+5 puntos]
    G -->|No| I[0 puntos]
    
    H --> J[REG-018: Trastornos Abdominales]
    I --> J
    J --> K{¿Presenta trastornos abdominales?}
    K -->|Sí| L[+5 puntos]
    K -->|No| M[0 puntos]
    
    L --> N[Acumular Total Agudo]
    M --> N
    N --> O{¿Total ≥ 36?}
    O -->|Sí| P[Diagnóstico Agudo Positivo]
    O -->|No| Q[Sin diagnóstico agudo]
```

## Figura 6.13 - Flujo de Generación de Órdenes

```mermaid
flowchart TD
    A[Evaluación Completa] --> B{¿Sintomatología Detectada?}
    B -->|Sí| C[REG-052: Generar Orden]
    B -->|No| D[Sin órdenes necesarias]
    
    C --> E[Orden de Estudios Generada]
    E --> F{¿Sintomatología Aguda?}
    F -->|Sí| G[REG-053: Informar Medicamentos]
    F -->|No| H[Sin restricciones medicamentosas]
    
    G --> I[Información de Medicamentos Contraproducentes]
    H --> J[Recomendaciones Generales]
    I --> J
    D --> J
```

## Figura 6.14 - Arquitectura de Clases de Reglas

```mermaid
classDiagram
    class Patient {
        +String id
        +String name
        +String age
        +String gender
    }
    
    class CuadroClinico {
        +String patientId
        +double sintomasCutanea
        +double sintomasAguda
        +double anamnesis
    }
    
    class DiagnosticoTemprano {
        +String patientId
        +Boolean sintomaCutanea
        +Boolean sintomaAguda
    }
    
    class GenerarOrden {
        +String patientId
        +Boolean estudios
    }
    
    class InformarWeb {
        +String patientId
        +Boolean medicamentos
    }
    
    class QuestionnaireResponse {
        +String questionId
        +String answer
    }
    
    Patient --> CuadroClinico : genera
    Patient --> DiagnosticoTemprano : evalúa
    DiagnosticoTemprano --> GenerarOrden : activa
    DiagnosticoTemprano --> InformarWeb : activa
    Patient --> QuestionnaireResponse : responde
```

## Tabla 6.1 - Resumen de Reglas por Categoría

| Categoría | Reglas | Rango de Puntuación | Umbral Diagnóstico |
|-----------|--------|-------------------|-------------------|
| Síntomas Cutáneos | REG-001 a REG-012 | +1 a +5 puntos | ≥ 22 puntos |
| Síntomas Agudos | REG-013 a REG-029 | +2 a +5 puntos | ≥ 36 puntos |
| Anamnesis | REG-030 a REG-049 | +0.5 a +5 puntos | Acumulativo |
| Diagnóstico | REG-050 a REG-051 | Boolean | Basado en umbrales |
| Órdenes | REG-052 | Boolean | Si hay sintomatología |
| Medicamentos | REG-053 | Boolean | Si hay sintomatología aguda |

## Tabla 6.2 - Puntuaciones por Síntoma

| Síntoma | Puntuación | Categoría | Relevancia |
|---------|------------|-----------|------------|
| Fotosensibilidad | +5 | Cutánea | Alta |
| Parestesias | +5 | Aguda | Alta |
| Familiares | +5 | Anamnesis | Alta |
| Fragilidad Cutánea | +5 | Cutánea | Alta |
| Paresia | +5 | Aguda | Alta |
| Trastornos Abdominales | +5 | Aguda | Alta |
| Hipertricosis | +4 | Cutánea | Muy Alta |
| Trastornos Psiquiátricos | +4 | Aguda | Muy Alta |
| Máculas | +2 | Cutánea | Media |
| Pruritos | +2 | Cutánea | Media |
| Nódulos | +1 | Cutánea | Baja |
| Diabetes | +0.5 | Anamnesis | Muy Baja |
