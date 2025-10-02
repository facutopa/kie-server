#!/bin/bash

echo "========================================"
echo "   Servidor Drools - Iniciando"
echo "========================================"
echo

echo "Verificando Java..."
if ! command -v java &> /dev/null; then
    echo "ERROR: Java no está instalado o no está en el PATH"
    exit 1
fi
java -version

echo
echo "Verificando Maven..."
if ! command -v mvn &> /dev/null; then
    echo "ERROR: Maven no está instalado o no está en el PATH"
    exit 1
fi
mvn -version

echo
echo "Compilando proyecto..."
mvn clean compile
if [ $? -ne 0 ]; then
    echo "ERROR: Error al compilar el proyecto"
    exit 1
fi

echo
echo "Iniciando servidor Drools..."
echo "El servidor estará disponible en: http://localhost:8080"
echo "Para detener el servidor presiona Ctrl+C"
echo

mvn spring-boot:run
