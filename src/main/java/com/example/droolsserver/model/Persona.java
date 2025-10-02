package com.example.droolsserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Persona {
    
    @JsonProperty("nombre")
    private String nombre;
    
    @JsonProperty("edad")
    private int edad;
    
    @JsonProperty("salario")
    private double salario;
    
    @JsonProperty("categoria")
    private String categoria;
    
    @JsonProperty("descuento")
    private double descuento;
    
    @JsonProperty("impuesto")
    private double impuesto;

    // Constructores
    public Persona() {}

    public Persona(String nombre, int edad, double salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", salario=" + salario +
                ", categoria='" + categoria + '\'' +
                ", descuento=" + descuento +
                ", impuesto=" + impuesto +
                '}';
    }
}
