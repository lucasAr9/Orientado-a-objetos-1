package com.example.FormaDePago;

public class Cuotas implements FormaDePago {
    public Cuotas(){}
    public double calcularCosto(double precio, int cant) {
        return precio * cant * 1.20;
    }
}
