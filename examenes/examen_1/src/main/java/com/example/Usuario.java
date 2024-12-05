package com.example;

import java.time.LocalDate;

import com.example.Bag.Bag;
import com.example.Bag.BagImpl;
import com.example.Evento.Evento;

public class Usuario {
    private String nombre;
    private List<Entrada> entradas;

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.entradas = new ArrayList<>();
    }

    public Entrada comprarEntradas(Evento e, boolean seguroReembolso) {
        Entrada entrada = new Entrada(seguroReembolso, LocalDate.now(), e);
        this.entradas.add(entrada);
        return entrada;
    }

<<<<<<< HEAD
    public void cancelarCompra(Entrada e) {
        this.entradas.removeAll(e);
    }

    public double consultarPrecioAsistencia(Evento e, LocalDate fecha) { // esto va en el evento
        Entrada entrada = new Entrada(false, fecha, e);
        return entrada.costoDeEntrada();
    }

=======
>>>>>>> e02f5ad00fd977c5543fa4dcbd3d65ce9d59b919
    public double calcularMontoRecuperar(Entrada e) {
        DataLapse tiempo = new DataLapse(e.getFechaCompra(), e.getEvento().getFecha());
        long t = tiempo.sizeInDays();
        double costoBase = 0;
        if (t >= 30) {
            costoBase = e.costoDeEntrada() * 0.50;
        } else {
            costoBase = 0;
        }
        if (e.isSeguroReembolso()) {
            return costoBase * 1.15;
        } else {
            return costoBase;
        }
    }

    public double calcularMontoEnPeriodo(DataLapse fechas) {
        return this.entradas.stream()
                .filter(e -> fechas.includesDate(e.getFechaCompra()))
                .mapToDouble(e -> e.costoDeEntrada())
                .count();
    }

    public Entrada siguientEventoComprado() {
        return this.entradas.stream()
                .filter(e -> e.getEvento().getFecha().isAfter(LocalDate.now()))
                .min((e1, e2) -> e1.getEvento().getFecha().compareTo(e2.getEvento().getFecha()))
                .orElse(null);
    }
}
