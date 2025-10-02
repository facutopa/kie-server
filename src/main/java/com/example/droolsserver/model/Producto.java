package com.example.droolsserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Producto {
    
    @JsonProperty("nombre")
    private String nombre;
    
    @JsonProperty("precio")
    private double precio;
    
    @JsonProperty("categoria")
    private String categoria;
    
    @JsonProperty("descuento")
    private double descuento;
    
    @JsonProperty("precioFinal")
    private double precioFinal;

    // Constructores
    public Producto() {}

    public Producto(String nombre, double precio, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
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

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", categoria='" + categoria + '\'' +
                ", descuento=" + descuento +
                ", precioFinal=" + precioFinal +
                '}';
    }
}
