package com.example;

import java.time.LocalDate;

import com.example.Evento.Evento;

public class Entrada {
    private boolean seguroReembolso;
    private LocalDate fechaCompra;
    private Evento e;
    
    public Entrada(boolean seguroReembolso, LocalDate fechaCompra, Evento e) {
        this.seguroReembolso = seguroReembolso;
        this.fechaCompra = fechaCompra;
        this.e = e;
    }

    public double costoDeEntrada() {
        if (this.isSeguroReembolso()) {
            return e.consultarPrecioAsistencia(LocalDate.now()) + 500;
        } else {
            return e.consultarPrecioAsistencia(LocalDate.now());
        }
    }

    public boolean isSeguroReembolso() {
        return seguroReembolso;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public Evento getEvento() {
        return e;
    }
}
