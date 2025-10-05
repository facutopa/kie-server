# Sistema de Diagnóstico de Porfiria con Drools

Este proyecto implementa un sistema de diagnóstico de Porfiria usando Spring Boot y Drools que expone una API REST para evaluar pacientes basándose en reglas médicas especializadas.

## Características

- ✅ Servidor Spring Boot con Drools integrado
- ✅ API REST especializada para diagnóstico de Porfiria
- ✅ 56 reglas médicas especializadas (síntomas cutáneos, agudos, anamnesis)
- ✅ Sistema de puntuación por categorías clínicas
- ✅ Generación automática de diagnósticos y órdenes de estudios
- ✅ Base de datos H2 para desarrollo
- ✅ Documentación completa de la API

## Tecnologías Utilizadas

- **Java 11**
- **Spring Boot 2.7.18**
- **Drools 7.74.1.Final**
- **Maven**
- **H2 Database**

## Instalación y Ejecución

### Prerrequisitos

- Java 11 o superior
- Maven 3.6 o superior

### Pasos para ejecutar

1. **Clonar o descargar el proyecto**
   ```bash
   cd kie-server
   ```

2. **Compilar el proyecto**
   ```bash
   mvn clean compile
   ```

3. **Ejecutar la aplicación**
   ```bash
   mvn spring-boot:run
   ```

4. **Verificar que el servidor esté funcionando**
   - Abrir navegador en: http://localhost:8080/api/porfiria/health
   - Debería mostrar: "Sistema de Diagnóstico de Porfiria está funcionando correctamente"

## API y Contrato

### Endpoints principales
- GET `/api/porfiria/health` — estado del servidor
- POST `/api/porfiria/evaluar` — evaluación completa (diagnóstico, órdenes, medicamentos, cuadro clínico)
- POST `/api/porfiria/diagnostico` — solo diagnóstico
- POST `/api/porfiria/ordenes` — solo órdenes (estudios: boolean)
- POST `/api/porfiria/cuadro-clinico` — solo cuadro clínico (puntuaciones)

### Request (un único cuestionario)
```json
{
  "patientId": "P001",
  "firstName": "María",
  "lastName": "González",
  "dni": "12345678",
  "age": 35,
  "gender": "F",
  "familyHistory": true,
  "alcoholConsumption": false,
  "fastingStatus": true,
  "responses": [
    { "questionId": "parestesias", "answer": "SI", "patientId": "P001" }
  ]
}
```

### Respuesta consistente (si no aplica, viene en false)
```json
{
  "cuadroClinico": {
    "patientId": "P001",
    "sintomasCutanea": 0.0,
    "sintomasAguda": 33.0,
    "anamnesis": 15.0
  },
  "diagnostico": {
    "patientId": "P001",
    "sintomaCutanea": false,
    "sintomaAguda": true
  },
  "ordenes": {
    "patientId": "P001",
    "estudios": true
  },
  "medicamentos": {
    "patientId": "P001",
    "medicamentos": true
  }
}
```

### Esquemas
- Diagnóstico: `{ patientId, sintomaCutanea: boolean, sintomaAguda: boolean }`
- Órdenes: `{ patientId, estudios: boolean }`
- Medicamentos: `{ patientId, medicamentos: boolean }`
- Cuadro clínico: `{ patientId, sintomasCutanea: number, sintomasAguda: number, anamnesis: number }`

### OpenAPI/Swagger
- Archivo `openapi.yaml` en la raíz del proyecto. Importable en Swagger UI/Postman y válido para generar SDKs.

## Reglas Médicas Implementadas

### Síntomas Cutáneos (12 reglas)

1. **Máculas:** +1 punto
2. **Fragilidad Cutánea:** +5 puntos
3. **Hipertricosis:** +4 puntos
4. **Nódulos:** +1 punto
5. **Lesiones Oculares:** +1 punto
6. **Costras:** +3 puntos
7. **Quistes de Milia:** +3 puntos
8. **Hiperpigmentación:** +5 puntos
9. **Ampollas:** +5 puntos
10. **Fotosensibilidad:** +5 puntos
11. **Pruritos:** +2 puntos
12. **Tricosis:** +3 puntos

### Síntomas Agudos (17 reglas)

1. **Trastornos Psiquiátricos:** +4 puntos
2. **Parestesias:** +5 puntos
3. **Cefaleas:** +3 puntos
4. **Paresia:** +5 puntos
5. **Convulsiones:** +3 puntos
6. **Trastornos Abdominales:** +5 puntos
7. **Síndrome Ácido Sensitivo:** +2 puntos
8. **Palpitaciones:** +3 puntos
9. **Anorexia:** +2 puntos
10. **Estrés:** +5 puntos
11. **Trastornos Neurológicos:** +4 puntos
12. **Dolores Musculares:** +3 puntos
13. **Mareos:** +3 puntos
14. **Parálisis:** +4 puntos
15. **Dolor Abdominal/Lumbar:** +5 puntos
16. **Constipación:** +3 puntos
17. **Astenia:** +4 puntos

### Anamnesis (20 reglas)

1. **Color Orina Oscura/Ámbar:** +5 puntos
2. **Familiares:** +5 puntos
3. **Diabetes:** +0.5 puntos
4. **HTA:** +0.5 puntos
5. **Tiroides:** +0.5 puntos
6. **Celiaquía:** +0.5 puntos
7. **Lupus:** +0.5 puntos
8. **Operaciones:** +1 punto
9. **Contacto Policlorados:** +1 punto
10. **Contacto Otras Drogas:** +1 punto
11. **Contacto Plomo:** +0.5 puntos
12. **Contacto Otros Metales:** +0.5 puntos
13. **Cercanía Fábrica:** +1 punto
14. **Contacto Veneno:** +1 punto
15. **Contacto Derivado Petróleo:** +1 punto
16. **Consume Alcohol:** +5 puntos
17. **Fuma:** +2 puntos
18. **Barbitúricos:** +5 puntos
19. **Medicamentos Hormonas:** +5 puntos
20. **Anomalías Períodos Menstruales:** +4 puntos

### Criterios de Diagnóstico

1. **Porfiria Cutánea:**
   - Síntomas cutáneos >= 22 puntos
   - O anamnesis >= 12 puntos

2. **Porfiria Aguda:**
   - Síntomas agudos >= 36 puntos
   - O anamnesis >= 12 puntos

3. **Porfiria Mixta:**
   - Ambos criterios presentes

## Ejemplos de Uso con cURL

### Probar el estado del servidor
```bash
curl -X GET http://localhost:8080/api/porfiria/health
```

### Evaluar un paciente con síntomas cutáneos
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
      }
    ]
  }'
```

### Evaluar un paciente con síntomas agudos
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
        "questionId": "dolorAbdominalLumbar",
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

## Base de Datos H2

Para desarrollo, se incluye una base de datos H2 en memoria. Puedes acceder a la consola web en:
- URL: http://localhost:8080/h2-console
- JDBC URL: jdbc:h2:mem:testdb
- Usuario: sa
- Contraseña: (vacía)

## Estructura del Proyecto

```
src/
├── main/
│   ├── java/com/example/droolsserver/
│   │   ├── DroolsServerApplication.java
│   │   ├── config/
│   │   │   └── DroolsConfig.java
│   │   ├── controller/
│   │   │   ├── PorfiriaController.java
│   │   │   └── PorfiriaInfoController.java
│   │   ├── model/
│   │   │   ├── Patient.java
│   │   │   ├── QuestionnaireResponse.java
│   │   │   ├── CuadroClinico.java
│   │   │   ├── DiagnosticoTemprano.java
│   │   │   ├── GenerarOrden.java
│   │   │   ├── InformarWeb.java
│   │   │   └── Recommendation.java
│   │   └── service/
│   │       └── DroolsService.java
│   └── resources/
│       ├── application.yml
│       ├── application.properties
│       └── rules/
│           └── reglas.drl
└── test/
```

## Personalización

### Agregar Nuevas Reglas Médicas

1. Edita el archivo `src/main/resources/rules/reglas.drl`
2. Agrega tus reglas usando la sintaxis de Drools
3. Reinicia la aplicación

### Agregar Nuevos Modelos de Datos

1. Crea nuevas clases de modelo en `src/main/java/com/example/droolsserver/model/`
2. Agrega reglas correspondientes en `reglas.drl`
3. Crea endpoints en los controladores

### Modificar Criterios de Diagnóstico

1. Edita las reglas de diagnóstico en `reglas.drl`
2. Ajusta los umbrales de puntuación según necesidades clínicas
3. Reinicia la aplicación

## Solución de Problemas

### Error de compilación
- Verifica que tengas Java 11 instalado
- Ejecuta `mvn clean compile` para limpiar y recompilar

### Error de puerto ocupado
- Cambia el puerto en `application.yml` o `application.properties`
- O mata el proceso que usa el puerto 8080

### Error de reglas no encontradas
- Verifica que el archivo `reglas.drl` esté en `src/main/resources/rules/`
- Revisa la sintaxis de las reglas

## Contribución

1. Fork el proyecto
2. Crea una rama para tu feature (`git checkout -b feature/nueva-funcionalidad`)
3. Commit tus cambios (`git commit -am 'Agregar nueva funcionalidad'`)
4. Push a la rama (`git push origin feature/nueva-funcionalidad`)
5. Crea un Pull Request

## Licencia

Este proyecto está bajo la Licencia MIT. Ver el archivo `LICENSE` para más detalles.
