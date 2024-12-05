package com.example.Evento;

import java.time.LocalDate;

public abstract class Evento {
    private String nombre;
    private LocalDate fecha;
    private String temaPrincipal;
    private double precioInscripcion;
    private double precioRemera;

    public Evento(String nombre, LocalDate fecha, String temaPrincipal, double precioInscripcion, double precioRemera) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.temaPrincipal = temaPrincipal;
        this.precioInscripcion = precioInscripcion;
        this.precioRemera = precioRemera;
    }

    public abstract double costoDelEvento();

    public double consultarPrecioAsistencia(LocalDate fecha) {
        if (fecha.isEqual(LocalDate.now())) {
            return this.costoDelEvento() * 1.20;
        } else {
            return this.costoDelEvento();
        }
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getTemaPrincipal() {
        return temaPrincipal;
    }

    public double getPrecioInscripcion() {
        return precioInscripcion;
    }

    public double getPrecioRemera() {
        return precioRemera;
    }
}
