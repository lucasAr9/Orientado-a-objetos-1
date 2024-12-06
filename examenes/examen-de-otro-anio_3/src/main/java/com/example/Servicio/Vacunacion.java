package com.example;

public class Vacunacion extends IntervencionMedica {
    private String nombreVacuna;
    private double costoVacuna;

    public Servicio(Mascota m, Veterinario vet, double adicionalMateriales, double adicionalDomingos, String nombre, double costo) {
        super(m, vet, adicionalMateriales, adicionalDomingos);
        this.nombreVacuna = nombre;
        this.costoVacuna = costo;
    }

    public double getCostoVacuna() {
        return this.costoVacuna;
    }

    public double costo() {
        double costo = this.veterinario.getHonorarios() + this.getAdicionalMateriales() + this.getCostoVacuna();
        return LocalDate.now().getDayOfWeek().equals(DayOfWeek.SUNDAY) ? costo + this.getAdicionalDomingos() : costo;
    }
}