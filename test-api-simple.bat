@echo off
echo ========================================
echo    Prueba Simple de la API
echo ========================================
echo.

echo 1. Verificando estado del servidor...
curl -X GET http://localhost:8080/api/porfiria/health
echo.
echo.

echo 2. Probando endpoint de test simple...
curl -X POST http://localhost:8080/api/porfiria/test ^
  -H "Content-Type: application/json" ^
  -d "{\"test\": \"simple\"}"
echo.
echo.

echo 3. Probando endpoint de test con datos del paciente...
curl -X POST http://localhost:8080/api/porfiria/test ^
  -H "Content-Type: application/json" ^
  -d "{\"patientId\": \"P001\", \"firstName\": \"Test\", \"lastName\": \"User\"}"
echo.
echo.

echo ========================================
echo    Pruebas completadas
echo ========================================
pause
