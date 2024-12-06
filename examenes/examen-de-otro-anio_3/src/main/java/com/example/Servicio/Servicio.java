package com.example;

public abstract class Servicio {
    private Mascota mascota;
    private LocalDate fechaAtencion;

    public Servicio(Mascota m) {
        this.mascota = m;
        this.fechaAtencion = LocalDate.now();
    }

    public LocalDate getFechaAtencion() {
        return this.fechaAtencion;
    }

    public abstract double costo();
}