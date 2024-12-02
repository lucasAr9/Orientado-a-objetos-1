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
        double costoBase = 0;
        if (this.isSeguroReembolso()) {
            costoBase = e.costoDelEvento() + 500;
        } else {
            costoBase = e.costoDelEvento();
        }
        if (this.getFechaCompra().isEqual(LocalDate.now())) {
            return costoBase * 1.20;
        } else {
            return costoBase;
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
