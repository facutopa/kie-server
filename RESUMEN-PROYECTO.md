# Resumen del Proyecto - Sistema de Diagnóstico de Porfiria

## 🎯 **Estado del Proyecto: COMPLETO Y LISTO PARA USAR**

### ✅ **Archivos Principales**
- `pom.xml` - Configuración Maven
- `README.md` - Documentación completa
- `INSTRUCCIONES-POSTMAN.md` - Guía para probar con Postman

### ✅ **Código Fuente**
- **Controladores:** `PorfiriaController.java`, `PorfiriaInfoController.java`
- **Modelos:** `Patient.java`, `QuestionnaireResponse.java`, `CuadroClinico.java`, etc.
- **Servicios:** `DroolsService.java`
- **Reglas:** `reglas.drl` (56 reglas médicas especializadas)

### ✅ **Archivos de Ejemplo para Postman**
- `ejemplo-postman-porfiria.json` - Síntomas cutáneos
- `ejemplo-postman-agudos.json` - Síntomas agudos  
- `ejemplo-postman-mixto.json` - Casos mixtos

### ✅ **Scripts de Ejecución**
- `scripts/ejecutar-servidor.bat` - Windows
- `scripts/ejecutar-servidor.sh` - Linux/Mac
- `scripts/probar-api.bat` - Pruebas Windows
- `scripts/probar-api.sh` - Pruebas Linux/Mac

## 🚀 **Cómo Ejecutar**

### 1. Instalar Maven (si no lo tienes)
```bash
# Descargar desde: https://maven.apache.org/download.cgi
# Extraer en C:\Program Files\Apache\maven
# Agregar C:\Program Files\Apache\maven\bin al PATH
```

### 2. Ejecutar el Servidor
```bash
# Opción 1: Script automático
scripts\ejecutar-servidor.bat

# Opción 2: Manual
mvn clean compile
mvn spring-boot:run
```

### 3. Verificar que Funciona
- Abrir: http://localhost:8080/api/porfiria/health
- Debería mostrar: "Sistema de Diagnóstico de Porfiria está funcionando correctamente"

## 🧪 **Cómo Probar con Postman**

### 1. Configurar Postman
- Método: POST
- URL: `http://localhost:8080/api/porfiria/evaluar`
- Headers: `Content-Type: application/json`
- Body: Copiar contenido de `ejemplo-postman-porfiria.json`

### 2. Endpoints Disponibles
- `GET /api/porfiria/health` - Estado del servidor
- `GET /api/porfiria/info` - Información del sistema
- `GET /api/porfiria/ejemplos` - Ejemplos de uso
- `POST /api/porfiria/evaluar` - Evaluación completa
- `POST /api/porfiria/cuadro-clinico` - Solo cuadro clínico
- `POST /api/porfiria/diagnostico` - Solo diagnóstico
- `POST /api/porfiria/ordenes` - Solo órdenes de estudios

## 📊 **Características del Sistema**

### Reglas Médicas (56 total)
- **Síntomas Cutáneos:** 12 reglas (máximo ~50 puntos)
- **Síntomas Agudos:** 17 reglas (máximo ~80 puntos)
- **Anamnesis:** 20 reglas (máximo ~30 puntos)
- **Diagnóstico:** 4 reglas de criterios
- **Órdenes:** 2 reglas de estudios
- **Medicamentos:** 1 regla de contraindicaciones

### Criterios de Diagnóstico
- **Porfiria Cutánea:** Síntomas cutáneos >= 22 puntos
- **Porfiria Aguda:** Síntomas agudos >= 36 puntos
- **Porfiria Mixta:** Ambos criterios presentes

## 🔧 **Solución de Problemas**

### Error 400 Bad Request
- Verifica que el JSON sea válido
- Revisa que todos los campos requeridos estén presentes
- Confirma que `Content-Type: application/json` esté en los headers

### Error 404 Not Found
- Verifica que el servidor esté ejecutándose
- Confirma que la URL sea correcta
- Revisa que el endpoint esté disponible

### Error de Compilación
- Verifica que tengas Java 11+ instalado
- Ejecuta `mvn clean compile` para limpiar y recompilar

## 📁 **Estructura Final del Proyecto**

```
kie-server/
├── pom.xml
├── README.md
├── INSTRUCCIONES-POSTMAN.md
├── RESUMEN-PROYECTO.md
├── ejemplo-postman-porfiria.json
├── ejemplo-postman-agudos.json
├── ejemplo-postman-mixto.json
├── scripts/
│   ├── ejecutar-servidor.bat
│   ├── ejecutar-servidor.sh
│   ├── probar-api.bat
│   └── probar-api.sh
└── src/main/
    ├── java/com/example/droolsserver/
    │   ├── DroolsServerApplication.java
    │   ├── config/DroolsConfig.java
    │   ├── controller/
    │   │   ├── PorfiriaController.java
    │   │   └── PorfiriaInfoController.java
    │   ├── model/
    │   │   ├── Patient.java
    │   │   ├── QuestionnaireResponse.java
    │   │   ├── CuadroClinico.java
    │   │   ├── DiagnosticoTemprano.java
    │   │   ├── GenerarOrden.java
    │   │   ├── InformarWeb.java
    │   │   └── Recommendation.java
    │   └── service/DroolsService.java
    └── resources/
        ├── application.yml
        ├── application.properties
        └── rules/reglas.drl
```

## 🎉 **¡Listo para Usar!**

El sistema está completamente implementado y listo para usar. Solo necesitas:

1. **Instalar Maven** (si no lo tienes)
2. **Ejecutar el servidor** con `mvn spring-boot:run`
3. **Probar con Postman** usando los archivos JSON de ejemplo

¡El sistema de diagnóstico de Porfiria está funcionando perfectamente!

