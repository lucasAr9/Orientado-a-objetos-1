package com.example;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PlazoFijo implements Inversion {
    private double monto;
    private double interes;
    private LocalDate fechaConstitucion;

    public PlazoFijo(double monto, double interes, LocalDate fecha) {
        this.monto = monto;
        this.interes = interes;
        this.fechaConstitucion = fecha;
    }

    public double valorActual() {
        LocalDate fechaActual = LocalDate.now();
        long cantDias = ChronoUnit.DAYS.between(fechaConstitucion, fechaActual);
        return (double) monto * Math.pow(1 + interes, cantDias);
    }
}
