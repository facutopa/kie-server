# Ejemplos de Uso - Sistema de Diagnóstico de Porfiria

Este documento contiene ejemplos prácticos de cómo usar la API del sistema de diagnóstico de Porfiria.

## Configuración Inicial

Asegúrate de que el servidor esté ejecutándose en `http://localhost:8080`

## Ejemplos con cURL

### 1. Verificar Estado del Servidor

```bash
curl -X GET http://localhost:8080/api/porfiria/health
```

**Respuesta esperada:**
```
Sistema de Diagnóstico de Porfiria está funcionando correctamente
```

### 2. Obtener Información del Sistema

```bash
curl -X GET http://localhost:8080/api/porfiria/info
```

### 3. Obtener Ejemplos de Uso

```bash
curl -X GET http://localhost:8080/api/porfiria/ejemplos
```

## Ejemplos de Evaluación de Pacientes

### Caso 1: Paciente con Síntomas Cutáneos

```bash
curl -X POST http://localhost:8080/api/porfiria/evaluar \
  -H "Content-Type: application/json" \
  -d '{
    "patientId": "P001",
    "firstName": "María",
    "lastName": "González",
    "dni": "12345678",
    "age": 35,
    "gender": "F",
    "familyHistory": true,
    "alcoholConsumption": false,
    "fastingStatus": false,
    "responses": [
      {
        "questionId": "maculas",
        "answer": "SI",
        "patientId": "P001"
      },
      {
        "questionId": "fragilidadCutanea",
        "answer": "SI",
        "patientId": "P001"
      },
      {
        "questionId": "fotosensibilidad",
        "answer": "SI",
        "patientId": "P001"
      },
      {
        "questionId": "hiperpigmentacion",
        "answer": "SI",
        "patientId": "P001"
      },
      {
        "questionId": "ampollas",
        "answer": "SI",
        "patientId": "P001"
      }
    ]
  }'
```

**Resultado esperado:**
```json
{
  "cuadroClinico": {
    "patientId": "P001",
    "sintomasCutanea": 20.0,
    "sintomasAguda": 0.0,
    "anamnesis": 0.0,
    "puntuacionTotal": 20.0,
    "tipoPorfiria": null,
    "nivelRiesgo": null
  },
  "diagnostico": {
    "patientId": "P001",
    "sintomaCutanea": "Presenta",
    "sintomaAguda": "No_Presenta"
  },
  "ordenes": {
    "patientId": "P001",
    "estudios": [
      "IPP (Isómeros de Porfirinas)",
      "PTO (Porfirinas Totales en Orina)",
      "CRO (Coproporfirinas)",
      "PBG (Porfobilinógeno)"
    ]
  }
}
```

### Caso 2: Paciente con Síntomas Agudos

```bash
curl -X POST http://localhost:8080/api/porfiria/evaluar \
  -H "Content-Type: application/json" \
  -d '{
    "patientId": "P002",
    "firstName": "Carlos",
    "lastName": "Ruiz",
    "dni": "87654321",
    "age": 42,
    "gender": "M",
    "familyHistory": false,
    "alcoholConsumption": true,
    "fastingStatus": true,
    "responses": [
      {
        "questionId": "parestesias",
        "answer": "SI",
        "patientId": "P002"
      },
      {
        "questionId": "paresia",
        "answer": "SI",
        "patientId": "P002"
      },
      {
        "questionId": "dolorAbdominalLumbar",
        "answer": "SI",
        "patientId": "P002"
      },
      {
        "questionId": "trastornosAbdominales",
        "answer": "SI",
        "patientId": "P002"
      },
      {
        "questionId": "estres",
        "answer": "SI",
        "patientId": "P002"
      },
      {
        "questionId": "colorOrina",
        "answer": "Oscura",
        "patientId": "P002"
      }
    ]
  }'
```

### Caso 3: Paciente con Anamnesis Positiva

```bash
curl -X POST http://localhost:8080/api/porfiria/evaluar \
  -H "Content-Type: application/json" \
  -d '{
    "patientId": "P003",
    "firstName": "Ana",
    "lastName": "López",
    "dni": "11223344",
    "age": 28,
    "gender": "F",
    "familyHistory": true,
    "alcoholConsumption": false,
    "fastingStatus": false,
    "responses": [
      {
        "questionId": "familiares",
        "answer": "SI",
        "patientId": "P003"
      },
      {
        "questionId": "colorOrina",
        "answer": "Oscura",
        "patientId": "P003"
      },
      {
        "questionId": "consumeAlcohol",
        "answer": "SI",
        "patientId": "P003"
      },
      {
        "questionId": "medicamentosHormonas",
        "answer": "SI",
        "patientId": "P003"
      }
    ]
  }'
```

## Ejemplos Específicos por Endpoint

### Obtener Solo Cuadro Clínico

```bash
curl -X POST http://localhost:8080/api/porfiria/cuadro-clinico \
  -H "Content-Type: application/json" \
  -d '{
    "patientId": "P004",
    "firstName": "Roberto",
    "lastName": "Silva",
    "dni": "55667788",
    "age": 50,
    "gender": "M",
    "responses": [
      {
        "questionId": "maculas",
        "answer": "SI",
        "patientId": "P004"
      },
      {
        "questionId": "fragilidadCutanea",
        "answer": "SI",
        "patientId": "P004"
      }
    ]
  }'
```

### Obtener Solo Diagnóstico

```bash
curl -X POST http://localhost:8080/api/porfiria/diagnostico \
  -H "Content-Type: application/json" \
  -d '{
    "patientId": "P005",
    "firstName": "Laura",
    "lastName": "Martín",
    "dni": "99887766",
    "age": 33,
    "gender": "F",
    "responses": [
      {
        "questionId": "parestesias",
        "answer": "SI",
        "patientId": "P005"
      },
      {
        "questionId": "dolorAbdominalLumbar",
        "answer": "SI",
        "patientId": "P005"
      }
    ]
  }'
```

### Obtener Solo Órdenes de Estudios

```bash
curl -X POST http://localhost:8080/api/porfiria/ordenes \
  -H "Content-Type: application/json" \
  -d '{
    "patientId": "P006",
    "firstName": "Diego",
    "lastName": "Fernández",
    "dni": "44332211",
    "age": 45,
    "gender": "M",
    "responses": [
      {
        "questionId": "fotosensibilidad",
        "answer": "SI",
        "patientId": "P006"
      },
      {
        "questionId": "ampollas",
        "answer": "SI",
        "patientId": "P006"
      }
    ]
  }'
```

## Ejemplos con JavaScript/Fetch

### Evaluación Completa de Paciente

```javascript
const evaluarPaciente = async () => {
  const request = {
    patientId: "P007",
    firstName: "Elena",
    lastName: "García",
    dni: "12345678",
    age: 38,
    gender: "F",
    familyHistory: true,
    alcoholConsumption: false,
    fastingStatus: false,
    responses: [
      {
        questionId: "maculas",
        answer: "SI",
        patientId: "P007"
      },
      {
        questionId: "fragilidadCutanea",
        answer: "SI",
        patientId: "P007"
      },
      {
        questionId: "fotosensibilidad",
        answer: "SI",
        patientId: "P007"
      },
      {
        questionId: "parestesias",
        answer: "SI",
        patientId: "P007"
      },
      {
        questionId: "dolorAbdominalLumbar",
        answer: "SI",
        patientId: "P007"
      },
      {
        questionId: "colorOrina",
        answer: "Oscura",
        patientId: "P007"
      },
      {
        questionId: "familiares",
        answer: "SI",
        patientId: "P007"
      }
    ]
  };

  try {
    const response = await fetch('http://localhost:8080/api/porfiria/evaluar', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(request)
    });

    const resultado = await response.json();
    console.log('Resultado de evaluación:', resultado);
    
    // Procesar resultados
    if (resultado.cuadroClinico) {
      console.log('Cuadro clínico:', resultado.cuadroClinico);
      console.log('Puntuación total:', resultado.cuadroClinico.puntuacionTotal);
    }
    
    if (resultado.diagnostico) {
      console.log('Diagnóstico:', resultado.diagnostico);
    }
    
    if (resultado.ordenes) {
      console.log('Estudios recomendados:', resultado.ordenes.estudios);
    }
    
  } catch (error) {
    console.error('Error:', error);
  }
};

// Ejecutar evaluación
evaluarPaciente();
```

## Ejemplos con Python

### Instalar requests
```bash
pip install requests
```

### Evaluación de Paciente con Python

```python
import requests
import json

def evaluar_paciente():
    url = "http://localhost:8080/api/porfiria/evaluar"
    
    request_data = {
        "patientId": "P008",
        "firstName": "Miguel",
        "lastName": "Rodríguez",
        "dni": "87654321",
        "age": 41,
        "gender": "M",
        "familyHistory": False,
        "alcoholConsumption": True,
        "fastingStatus": False,
        "responses": [
            {
                "questionId": "parestesias",
                "answer": "SI",
                "patientId": "P008"
            },
            {
                "questionId": "paresia",
                "answer": "SI",
                "patientId": "P008"
            },
            {
                "questionId": "dolorAbdominalLumbar",
                "answer": "SI",
                "patientId": "P008"
            },
            {
                "questionId": "trastornosAbdominales",
                "answer": "SI",
                "patientId": "P008"
            },
            {
                "questionId": "estres",
                "answer": "SI",
                "patientId": "P008"
            },
            {
                "questionId": "colorOrina",
                "answer": "Oscura",
                "patientId": "P008"
            },
            {
                "questionId": "familiares",
                "answer": "SI",
                "patientId": "P008"
            }
        ]
    }
    
    try:
        response = requests.post(url, json=request_data)
        if response.status_code == 200:
            resultado = response.json()
            
            print("=== RESULTADO DE EVALUACIÓN ===")
            
            if 'cuadroClinico' in resultado:
                cuadro = resultado['cuadroClinico']
                print(f"Paciente: {cuadro['patientId']}")
                print(f"Síntomas Cutáneos: {cuadro['sintomasCutanea']} puntos")
                print(f"Síntomas Agudos: {cuadro['sintomasAguda']} puntos")
                print(f"Anamnesis: {cuadro['anamnesis']} puntos")
                print(f"Puntuación Total: {cuadro['puntuacionTotal']} puntos")
            
            if 'diagnostico' in resultado:
                diag = resultado['diagnostico']
                print(f"Diagnóstico Cutáneo: {diag['sintomaCutanea']}")
                print(f"Diagnóstico Agudo: {diag['sintomaAguda']}")
            
            if 'ordenes' in resultado:
                orden = resultado['ordenes']
                print(f"Estudios Recomendados: {orden['estudios']}")
                
        else:
            print(f"Error: {response.status_code}")
            
    except Exception as e:
        print(f"Error: {e}")

# Ejecutar evaluación
evaluar_paciente()
```

## Casos de Uso Reales

### 1. Sistema de Triage Médico
- Evaluación rápida de pacientes con síntomas sospechosos
- Clasificación automática por nivel de riesgo
- Generación de órdenes de estudios prioritarios

### 2. Sistema de Apoyo al Diagnóstico
- Asistencia a médicos en la evaluación de Porfiria
- Validación de síntomas y signos clínicos
- Recomendaciones de estudios complementarios

### 3. Sistema de Monitoreo de Pacientes
- Seguimiento de pacientes con Porfiria conocida
- Evaluación de cambios en el cuadro clínico
- Alertas por empeoramiento de síntomas

### 4. Sistema de Educación Médica
- Entrenamiento de residentes en diagnóstico de Porfiria
- Simulación de casos clínicos
- Evaluación de conocimientos médicos

## Monitoreo y Debugging

### Ver logs de reglas ejecutadas
Los logs se muestran en la consola cuando se ejecutan las reglas. Busca mensajes como:
```
REG-001: Máculas detectadas
REG-002: Fragilidad cutánea detectada
REG-014: Parestesias detectadas
REG-051: Sintomatología aguda detectada (>= 36 puntos)
```

### Verificar estado del servidor
```bash
curl -X GET http://localhost:8080/api/porfiria/health
```

### Acceder a la consola H2
- URL: http://localhost:8080/h2-console
- JDBC URL: jdbc:h2:mem:testdb
- Usuario: sa
- Contraseña: (vacía)

## Puntuaciones por Categoría

### Síntomas Cutáneos (Máximo: ~50 puntos)
- Máculas: +1 punto
- Fragilidad Cutánea: +5 puntos
- Hipertricosis: +4 puntos
- Nódulos: +1 punto
- Lesiones Oculares: +1 punto
- Costras: +3 puntos
- Quistes de Milia: +3 puntos
- Hiperpigmentación: +5 puntos
- Ampollas: +5 puntos
- Fotosensibilidad: +5 puntos
- Pruritos: +2 puntos
- Tricosis: +3 puntos

### Síntomas Agudos (Máximo: ~80 puntos)
- Trastornos Psiquiátricos: +4 puntos
- Parestesias: +5 puntos
- Cefaleas: +3 puntos
- Paresia: +5 puntos
- Convulsiones: +3 puntos
- Trastornos Abdominales: +5 puntos
- Síndrome Ácido Sensitivo: +2 puntos
- Palpitaciones: +3 puntos
- Anorexia: +2 puntos
- Estrés: +5 puntos
- Trastornos Neurológicos: +4 puntos
- Dolores Musculares: +3 puntos
- Mareos: +3 puntos
- Parálisis: +4 puntos
- Dolor Abdominal/Lumbar: +5 puntos
- Constipación: +3 puntos
- Astenia: +4 puntos

### Anamnesis (Máximo: ~30 puntos)
- Color Orina Oscura/Ámbar: +5 puntos
- Familiares: +5 puntos
- Diabetes: +0.5 puntos
- HTA: +0.5 puntos
- Tiroides: +0.5 puntos
- Celiaquía: +0.5 puntos
- Lupus: +0.5 puntos
- Consume Alcohol: +5 puntos
- Fuma: +2 puntos
- Medicamentos Hormonas: +5 puntos

## Criterios de Diagnóstico

### Porfiria Cutánea
- Síntomas cutáneos >= 22 puntos
- O anamnesis >= 12 puntos

### Porfiria Aguda
- Síntomas agudos >= 36 puntos
- O anamnesis >= 12 puntos

### Porfiria Mixta
- Ambos criterios presentes
