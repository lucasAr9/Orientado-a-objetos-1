package com.example;

public class Veterinario {
    private String nombre;
    private LocalDate fechaIngreso;
    private double honorarios;

    public Veterinario(String nombre, LocalDate fechaIngre, double honorarios) {
        this.nombre = nombre;
        this.fechaIngreso = fechaIngre;
        this.honorarios = honorarios;
    }

    public int antiguedad() {
        return Period.between(this.fechaIngreso, LocalDate.now()).getYears();
    }

    public double getHonorarios() {
        return this.honorarios;
    }
}