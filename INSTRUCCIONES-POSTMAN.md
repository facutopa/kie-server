# Instrucciones para Probar la API con Postman

## Configuración Inicial

1. **Asegúrate de que el servidor esté ejecutándose:**
   ```bash
   mvn spring-boot:run
   ```

2. **Verifica que el servidor esté funcionando:**
   - Abre Postman
   - GET: `http://localhost:8080/api/porfiria/health`
   - Debería devolver: "Sistema de Diagnóstico de Porfiria está funcionando correctamente"

## Endpoints Disponibles

### 1. Health Check
- **Método:** GET
- **URL:** `http://localhost:8080/api/porfiria/health`
- **Respuesta:** Mensaje de estado

### 2. Información del Sistema
- **Método:** GET
- **URL:** `http://localhost:8080/api/porfiria/info`
- **Respuesta:** Información sobre reglas y endpoints

### 3. Ejemplos de Uso
- **Método:** GET
- **URL:** `http://localhost:8080/api/porfiria/ejemplos`
- **Respuesta:** Ejemplos de JSON para probar

### 4. Evaluación Completa
- **Método:** POST
- **URL:** `http://localhost:8080/api/porfiria/evaluar`
- **Headers:** `Content-Type: application/json`
- **Body:** Usa uno de los archivos JSON de ejemplo

### 5. Solo Cuadro Clínico
- **Método:** POST
- **URL:** `http://localhost:8080/api/porfiria/cuadro-clinico`
- **Headers:** `Content-Type: application/json`
- **Body:** JSON con datos del paciente

### 6. Solo Diagnóstico
- **Método:** POST
- **URL:** `http://localhost:8080/api/porfiria/diagnostico`
- **Headers:** `Content-Type: application/json`
- **Body:** JSON con datos del paciente

### 7. Solo Órdenes de Estudios
- **Método:** POST
- **URL:** `http://localhost:8080/api/porfiria/ordenes`
- **Headers:** `Content-Type: application/json`
- **Body:** JSON con datos del paciente

## Archivos de Ejemplo

### Para Síntomas Cutáneos
Usa el contenido del archivo `ejemplo-postman-porfiria.json`

### Para Síntomas Agudos
Usa el contenido del archivo `ejemplo-postman-agudos.json`

### Para Casos Mixtos
Usa el contenido del archivo `ejemplo-postman-mixto.json`

## Pasos para Probar

1. **Importa los archivos JSON en Postman:**
   - Copia el contenido de `ejemplo-postman-porfiria.json`
   - Pega en el Body de Postman (raw, JSON)

2. **Configura la petición:**
   - Método: POST
   - URL: `http://localhost:8080/api/porfiria/evaluar`
   - Headers: `Content-Type: application/json`
   - Body: JSON de ejemplo

3. **Envía la petición y revisa la respuesta**

## Respuestas Esperadas

### Para Síntomas Cutáneos
- `cuadroClinico.sintomasCutanea` > 0
- `diagnostico.sintomaCutanea` = "Presenta"
- `ordenes.estudios` = ["IPP", "PTO", "CRO", "PBG"]

### Para Síntomas Agudos
- `cuadroClinico.sintomasAguda` > 0
- `diagnostico.sintomaAguda` = "Presenta"
- `ordenes.estudios` = ["PBG", "IPP", "ALA", "PTO"]

### Para Casos Mixtos
- Ambos tipos de síntomas presentes
- Diagnóstico mixto
- Estudios combinados

## Solución de Problemas

### Error 400 Bad Request
- Verifica que el JSON sea válido
- Asegúrate de que todos los campos requeridos estén presentes
- Revisa que `Content-Type: application/json` esté en los headers

### Error 404 Not Found
- Verifica que el servidor esté ejecutándose
- Confirma que la URL sea correcta
- Revisa que el endpoint esté disponible

### Error 500 Internal Server Error
- Revisa la consola del servidor para ver los logs de error
- Verifica que las reglas de Drools estén correctamente configuradas

