package com.example.Producto;

public abstract class Producto {
    private String nombre;
    private double costo;
    private String descripcion;

    public Producto(String nombre, double costo, String descripcion) {
        this.nombre = nombre;
        this.costo = costo;
        this.descripcion = descripcion;
    }

    public abstract double impuesto(int cant);

    public double getCosto() {
        return this.costo;
    }

    public String getNombre() {
        return this.nombre;
    }
}
