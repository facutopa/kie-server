# Ejemplos de Uso de la API Drools

Este documento contiene ejemplos prácticos de cómo usar la API del servidor Drools.

## Configuración Inicial

Asegúrate de que el servidor esté ejecutándose en `http://localhost:8080`

## Ejemplos con cURL

### 1. Verificar Estado del Servidor

```bash
curl -X GET http://localhost:8080/api/drools/health
```

**Respuesta esperada:**
```
Drools Server está funcionando correctamente
```

### 2. Obtener Información de Reglas

```bash
curl -X GET http://localhost:8080/api/reglas/info
```

### 3. Obtener Ejemplos de Uso

```bash
curl -X GET http://localhost:8080/api/reglas/ejemplos
```

## Ejemplos de Personas

### Persona Menor de Edad

```bash
curl -X POST http://localhost:8080/api/drools/persona \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Ana López",
    "edad": 16,
    "salario": 0
  }'
```

**Resultado esperado:**
```json
{
  "nombre": "Ana López",
  "edad": 16,
  "salario": 0,
  "categoria": "Menor",
  "descuento": 0.15,
  "impuesto": 0.0
}
```

### Persona Adulta Joven

```bash
curl -X POST http://localhost:8080/api/drools/persona \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Carlos Ruiz",
    "edad": 25,
    "salario": 35000
  }'
```

**Resultado esperado:**
```json
{
  "nombre": "Carlos Ruiz",
  "edad": 25,
  "salario": 35000,
  "categoria": "Adulto Joven",
  "descuento": 0.0,
  "impuesto": 0.15
}
```

### Persona Mayor

```bash
curl -X POST http://localhost:8080/api/drools/persona \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Roberto Silva",
    "edad": 65,
    "salario": 45000
  }'
```

**Resultado esperado:**
```json
{
  "nombre": "Roberto Silva",
  "edad": 65,
  "salario": 45000,
  "categoria": "Mayor",
  "descuento": 0.20,
  "impuesto": 0.15
}
```

## Ejemplos de Productos

### Producto Electrónico

```bash
curl -X POST http://localhost:8080/api/drools/producto \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "MacBook Pro",
    "precio": 2500,
    "categoria": "Electrónicos"
  }'
```

**Resultado esperado:**
```json
{
  "nombre": "MacBook Pro",
  "precio": 2500,
  "categoria": "Electrónicos",
  "descuento": 0.30,
  "precioFinal": 1750
}
```

### Producto de Ropa

```bash
curl -X POST http://localhost:8080/api/drools/producto \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Camiseta Nike",
    "precio": 50,
    "categoria": "Ropa"
  }'
```

**Resultado esperado:**
```json
{
  "nombre": "Camiseta Nike",
  "precio": 50,
  "categoria": "Ropa",
  "descuento": 0.15,
  "precioFinal": 42.5
}
```

### Producto Libro

```bash
curl -X POST http://localhost:8080/api/drools/producto \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Clean Code",
    "precio": 30,
    "categoria": "Libros"
  }'
```

**Resultado esperado:**
```json
{
  "nombre": "Clean Code",
  "precio": 30,
  "categoria": "Libros",
  "descuento": 0.05,
  "precioFinal": 28.5
}
```

## Ejemplos con Múltiples Productos

```bash
curl -X POST http://localhost:8080/api/drools/productos \
  -H "Content-Type: application/json" \
  -d '[
    {
      "nombre": "iPhone 15",
      "precio": 1200,
      "categoria": "Electrónicos"
    },
    {
      "nombre": "Pantalón Jeans",
      "precio": 80,
      "categoria": "Ropa"
    },
    {
      "nombre": "El Quijote",
      "precio": 15,
      "categoria": "Libros"
    }
  ]'
```

## Ejemplos con JavaScript/Fetch

### Procesar Persona

```javascript
const persona = {
  nombre: "María González",
  edad: 28,
  salario: 55000
};

fetch('http://localhost:8080/api/drools/persona', {
  method: 'POST',
  headers: {
    'Content-Type': 'application/json',
  },
  body: JSON.stringify(persona)
})
.then(response => response.json())
.then(data => {
  console.log('Resultado:', data);
})
.catch(error => {
  console.error('Error:', error);
});
```

### Procesar Producto

```javascript
const producto = {
  nombre: "Gaming Laptop",
  precio: 1800,
  categoria: "Electrónicos"
};

fetch('http://localhost:8080/api/drools/producto', {
  method: 'POST',
  headers: {
    'Content-Type': 'application/json',
  },
  body: JSON.stringify(producto)
})
.then(response => response.json())
.then(data => {
  console.log('Precio final:', data.precioFinal);
  console.log('Descuento aplicado:', data.descuento);
})
.catch(error => {
  console.error('Error:', error);
});
```

## Ejemplos con Python

### Instalar requests
```bash
pip install requests
```

### Procesar Persona

```python
import requests
import json

url = "http://localhost:8080/api/drools/persona"
persona = {
    "nombre": "Luis Martínez",
    "edad": 42,
    "salario": 75000
}

response = requests.post(url, json=persona)
if response.status_code == 200:
    resultado = response.json()
    print(f"Persona: {resultado['nombre']}")
    print(f"Categoría: {resultado['categoria']}")
    print(f"Descuento: {resultado['descuento']*100}%")
    print(f"Impuesto: {resultado['impuesto']*100}%")
else:
    print(f"Error: {response.status_code}")
```

### Procesar Producto

```python
import requests
import json

url = "http://localhost:8080/api/drools/producto"
producto = {
    "nombre": "Samsung Galaxy S24",
    "precio": 900,
    "categoria": "Electrónicos"
}

response = requests.post(url, json=producto)
if response.status_code == 200:
    resultado = response.json()
    print(f"Producto: {resultado['nombre']}")
    print(f"Precio original: ${resultado['precio']}")
    print(f"Descuento: {resultado['descuento']*100}%")
    print(f"Precio final: ${resultado['precioFinal']}")
else:
    print(f"Error: {response.status_code}")
```

## Casos de Uso Reales

### 1. Sistema de E-commerce
- Aplicar descuentos automáticos según categoría de producto
- Calcular impuestos según ubicación del cliente
- Aplicar descuentos por volumen de compra

### 2. Sistema de Recursos Humanos
- Categorizar empleados según edad y experiencia
- Calcular beneficios según salario
- Aplicar descuentos en seguros según perfil

### 3. Sistema de Seguros
- Calcular primas según edad y perfil de riesgo
- Aplicar descuentos por historial
- Determinar cobertura según categoría

### 4. Sistema de Ventas
- Aplicar descuentos por cliente VIP
- Calcular comisiones según volumen
- Determinar precios dinámicos

## Monitoreo y Debugging

### Ver logs de reglas ejecutadas
Los logs se muestran en la consola cuando se ejecutan las reglas. Busca mensajes como:
```
Persona Juan Pérez categorizada como Adulto
Descuento del 15% aplicado a Ana López
Impuesto del 15% aplicado a Carlos Ruiz
```

### Verificar estado del servidor
```bash
curl -X GET http://localhost:8080/api/drools/health
```

### Acceder a la consola H2
- URL: http://localhost:8080/h2-console
- JDBC URL: jdbc:h2:mem:testdb
- Usuario: sa
- Contraseña: (vacía)
