@echo off
echo ========================================
echo    Reiniciando Servidor Drools
echo ========================================
echo.

echo 1. Deteniendo procesos en puerto 8080...
for /f "tokens=5" %%a in ('netstat -ano ^| findstr :8080') do (
    echo Matando proceso %%a
    taskkill /PID %%a /F
)
echo.

echo 2. Esperando 3 segundos...
timeout /t 3 /nobreak > nul
echo.

echo 3. Iniciando servidor...
echo El servidor estará disponible en: http://localhost:8080
echo Para detener el servidor presiona Ctrl+C
echo.

java -jar target/drools-server-1.0.0.jar

pause

