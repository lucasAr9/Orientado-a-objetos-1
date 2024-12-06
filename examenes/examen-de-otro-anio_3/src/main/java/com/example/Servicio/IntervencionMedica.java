package com.example;

public abstract class IntervencionMedica extends Servicio {
    private double adicionalMateriales;
    private double adicionalDomingos;
    private Veterinario veterinario;

    public Servicio(Mascota m, Veterinario vet, double adicionalMateriales, double adicionalDomingos) {
        super(m);
        this.veterinario = vet;
        this.adicionalMateriales = adicionalMateriales;
        this.adicionalDomingos = adicionalDomingos;
    }

    public double getAdicionalMateriales() {
        return this.adicionalMateriales;
    }

    public double getAdicionalDomingos() {
        return this.adicionalDomingos;
    }

    public abstract double costo();
}