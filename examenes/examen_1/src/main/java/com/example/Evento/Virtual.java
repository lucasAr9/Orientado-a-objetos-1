package com.example.Evento;

import java.time.LocalDate;

public class Virtual extends Evento {
    private double montoPorEnvio;

    public Virtual(String nombre, LocalDate fecha, String temaPrincipal, double precioInscripcion, double precioRemera, double montoPorEnvio) {
        super(nombre, fecha, temaPrincipal, precioInscripcion, precioRemera);
        this.montoPorEnvio = montoPorEnvio;
    }

    public double costoDelEvento() {
        return this.getPrecioInscripcion() + this.getPrecioRemera() + this.getMontoPorEnvio();
    }

    public double getMontoPorEnvio() {
        return montoPorEnvio;
    }
}
