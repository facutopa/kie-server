@echo off
echo ========================================
echo    Probando API del Sistema de Porfiria
echo ========================================
echo.

echo 1. Verificando estado del servidor...
curl -X GET http://localhost:8080/api/porfiria/health
echo.
echo.

echo 2. Obteniendo información del sistema...
curl -X GET http://localhost:8080/api/porfiria/info
echo.
echo.

echo 3. Obteniendo ejemplos de uso...
curl -X GET http://localhost:8080/api/porfiria/ejemplos
echo.
echo.

echo 4. Probando evaluación de paciente con síntomas cutáneos...
curl -X POST http://localhost:8080/api/porfiria/evaluar ^
  -H "Content-Type: application/json" ^
  -d "{\"patientId\": \"P001\", \"firstName\": \"María\", \"lastName\": \"González\", \"dni\": \"12345678\", \"age\": 35, \"gender\": \"F\", \"familyHistory\": true, \"alcoholConsumption\": false, \"fastingStatus\": false, \"responses\": [{\"questionId\": \"maculas\", \"answer\": \"SI\", \"patientId\": \"P001\"}, {\"questionId\": \"fragilidadCutanea\", \"answer\": \"SI\", \"patientId\": \"P001\"}, {\"questionId\": \"fotosensibilidad\", \"answer\": \"SI\", \"patientId\": \"P001\"}]}"
echo.
echo.

echo 5. Probando evaluación de paciente con síntomas agudos...
curl -X POST http://localhost:8080/api/porfiria/evaluar ^
  -H "Content-Type: application/json" ^
  -d "{\"patientId\": \"P002\", \"firstName\": \"Carlos\", \"lastName\": \"Ruiz\", \"dni\": \"87654321\", \"age\": 42, \"gender\": \"M\", \"familyHistory\": false, \"alcoholConsumption\": true, \"fastingStatus\": true, \"responses\": [{\"questionId\": \"parestesias\", \"answer\": \"SI\", \"patientId\": \"P002\"}, {\"questionId\": \"dolorAbdominalLumbar\", \"answer\": \"SI\", \"patientId\": \"P002\"}, {\"questionId\": \"colorOrina\", \"answer\": \"Oscura\", \"patientId\": \"P002\"}]}"
echo.
echo.

echo ========================================
echo    Pruebas completadas
echo ========================================
pause
