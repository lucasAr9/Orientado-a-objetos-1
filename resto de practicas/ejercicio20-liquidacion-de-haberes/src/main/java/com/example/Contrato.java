package com.example;

import java.time.LocalDate;

public abstract class Contrato {
    private LocalDate fechaInicio;

    public Contrato(LocalDate fechaInit) {
        this.fechaInicio = fechaInit;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public abstract boolean esVigente();

    public abstract double montoCobrar();
}
