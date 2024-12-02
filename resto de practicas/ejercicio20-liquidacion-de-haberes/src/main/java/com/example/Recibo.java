package com.example;

import java.time.LocalDate;

public class Recibo {
    private String nombre;
    private String apellido;
    private long cuil;
    private int antiguedad;
    private LocalDate fechaEmision;
    private double montoCobrar;

    public Recibo(Empleado e) {
        this.nombre = e.getNombre();
        this.apellido = e.getApellido();
        this.cuil = e.getCuil();
        this.antiguedad = e.antiguedad();
        this.fechaEmision = LocalDate.now();
        this.montoCobrar = e.montoCobrar();
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public long getCuil() {
        return cuil;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public double getMontoCobrar() {
        return montoCobrar;
    }
}
