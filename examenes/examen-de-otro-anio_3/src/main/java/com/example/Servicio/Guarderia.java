package com.example;

public class Guarderia extends Servicio {
    private int cantDias;
    private double costoDiario;

    public Guarderia(Mascota m, int cant, double costo) {
        super(m);
        this.cantDias = cant;
        this.costoDiario = costo;
    }

    public int getCantDias() {
        return this.cantDias;
    }

    public double getCostoDiario() {
        return this.costoDiario;
    }

    public double costo() {
        double costo = this.getCantDias() * this.getCostoDiario();
        return this.mascota.masDeCinco() ? costo - (costo * 0.10) : costo;
    }
}