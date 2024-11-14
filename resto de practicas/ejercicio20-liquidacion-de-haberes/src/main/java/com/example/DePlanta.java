package com.example;

import java.time.LocalDate;

public class DePlanta extends Contrato {
    private double sueldoMensual;
    private double montoPorConyuge;
    private double montoPorHijos;
    
    public DePlanta(LocalDate fechaInit, double sueldoMensual, double montoPorConyuge, double montoPorHijos) {
        super(fechaInit);
        this.sueldoMensual = sueldoMensual;
        this.montoPorConyuge = montoPorConyuge;
        this.montoPorHijos = montoPorHijos;
    }

    public double getSueldoMensual() {
        return sueldoMensual;
    }

    public double getMontoPorConyuge() {
        return montoPorConyuge;
    }

    public double getMontoPorHijos() {
        return montoPorHijos;
    }

    public boolean contratoVigente() {
        return true;
    }

    public double montoCobrar() {
        return this.getSueldoMensual() + this.getMontoPorConyuge() + this.getMontoPorHijos();
    }
}
