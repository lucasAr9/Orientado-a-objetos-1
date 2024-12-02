package com.example;

import java.time.LocalDate;

public class PorHora extends Contrato {
    private LocalDate fechaFin;
    private double valorHora;
    private int horasPorMes;
    
    public PorHora(LocalDate fechaInit, LocalDate fechaFin, double valorHora, int horasPorMes) {
        super(fechaInit);
        this.fechaFin = fechaFin;
        this.valorHora = valorHora;
        this.horasPorMes = horasPorMes;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public double getValorHora() {
        return valorHora;
    }

    public int getHorasPorMes() {
        return horasPorMes;
    }

    public boolean esVigente() {
        return this.getFechaFin().isAfter(LocalDate.now());
    }

    public double montoCobrar() {
        return this.getValorHora() * this.getHorasPorMes();
    }
}
