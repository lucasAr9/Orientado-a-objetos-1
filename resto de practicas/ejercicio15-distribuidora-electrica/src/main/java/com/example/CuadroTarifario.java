package com.example;

public class CuadroTarifario {
    private double precioPorKWh;

    public CuadroTarifario(double precio) {
        this.precioPorKWh = precio;
    }

    public double getPrecioPorKWh() {
        return this.precioPorKWh;
    }

    public void setPrecioPorKWh(double precio) {
        this.precioPorKWh = precio;
    }
}
