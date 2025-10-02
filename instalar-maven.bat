@echo off
echo ========================================
echo    Instalador de Maven para Windows
echo ========================================
echo.

echo Este script te ayudará a instalar Maven manualmente.
echo.
echo PASO 1: Descargar Maven
echo ------------------------
echo 1. Ve a: https://maven.apache.org/download.cgi
echo 2. Descarga: apache-maven-3.9.6-bin.zip
echo 3. Guarda el archivo en tu carpeta de Descargas
echo.
pause

echo PASO 2: Extraer Maven
echo ---------------------
echo 1. Abre la carpeta de Descargas
echo 2. Haz clic derecho en apache-maven-3.9.6-bin.zip
echo 3. Selecciona "Extraer todo..."
echo 4. Extrae en: C:\Program Files\Apache\maven
echo.
echo Si la carpeta no existe, créala primero.
echo.
pause

echo PASO 3: Configurar Variables de Entorno
echo ----------------------------------------
echo 1. Presiona Win + R
echo 2. Escribe: sysdm.cpl
echo 3. Haz clic en "Variables de entorno"
echo 4. En "Variables del sistema", busca "Path"
echo 5. Haz clic en "Editar"
echo 6. Haz clic en "Nuevo"
echo 7. Agrega: C:\Program Files\Apache\maven\bin
echo 8. Haz clic en "Aceptar" en todas las ventanas
echo.
pause

echo PASO 4: Verificar Instalación
echo ------------------------------
echo Después de configurar las variables de entorno:
echo 1. Cierra esta ventana
echo 2. Abre una nueva ventana de PowerShell/CMD
echo 3. Ejecuta: mvn -version
echo.
echo Si ves la versión de Maven, ¡está instalado correctamente!
echo.

echo ========================================
echo    Instalación Completada
echo ========================================
pause
