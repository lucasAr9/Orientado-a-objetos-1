package com.example;

public class ConsultaMedica extends IntervencionMedica {
    public Servicio(Mascota m, Veterinario vet, double adicionalMateriales, double adicionalDomingos) {
        super(m, vet, adicionalMateriales, adicionalDomingos);
    }

    public double costo() {
        double costo = this.veterinario.getHonorarios() + this.getAdicionalMateriales() + (this.veterinario.antiguedad() * 100);
        return LocalDate.now().getDayOfWeek().equals(DayOfWeek.SUNDAY) ? costo + this.getAdicionalDomingos() : costo;
    }
}