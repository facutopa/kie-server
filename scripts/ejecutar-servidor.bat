@echo off
echo ========================================
echo    Servidor Drools - Iniciando
echo ========================================
echo.

echo Verificando Java...
java -version
if %errorlevel% neq 0 (
    echo ERROR: Java no está instalado o no está en el PATH
    pause
    exit /b 1
)

echo.
echo Verificando Maven...
mvn -version
if %errorlevel% neq 0 (
    echo ERROR: Maven no está instalado o no está en el PATH
    pause
    exit /b 1
)

echo.
echo Compilando proyecto...
mvn clean compile
if %errorlevel% neq 0 (
    echo ERROR: Error al compilar el proyecto
    pause
    exit /b 1
)

echo.
echo Iniciando servidor Drools...
echo El servidor estará disponible en: http://localhost:8080
echo Para detener el servidor presiona Ctrl+C
echo.

mvn spring-boot:run

pause
