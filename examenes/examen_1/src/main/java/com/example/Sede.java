package com.example;

public class Sede {
    private String nombre;
    private double precioEstadia;
    private int cantDias;

    public Sede(String nombre, double precioEstadia, int cantDias) {
        this.nombre = nombre;
        this.precioEstadia = precioEstadia;
        this.cantDias = cantDias;
    }

    public double calcularCosto() {
        return this.getPrecioEstadia() * this.getCantDias();
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public double getPrecioEstadia() {
        return precioEstadia;
    }
    
    public int getCantDias() {
        return cantDias;
    }
}
