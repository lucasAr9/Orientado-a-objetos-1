package com.example;

public class Acciones implements Inversion {
    private String nombre;
    private int cantidad;
    private double precio;
    
    public Acciones(String nombre, int cant, double precio) {
        this.nombre = nombre;
        this.cantidad = cant;
        this.precio = precio;
    }

    public double valorActual() {
        return this.cantidad * this.precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
