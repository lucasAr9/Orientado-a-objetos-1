package com.example.FormaDePago;

public class AlContado implements FormaDePago {
    public AlContado(){}
    public double calcularCosto(double precio, int cant) {
        return precio * cant;
    }
}
