package com.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Propiedad {
    private String direccion;
    private String descripcion;
    private double precioPorNoche;
    private List<Reserva> reservas;
    
    public Propiedad(String direccion, String descripcion, double precioPorNoche) {
        this.direccion = direccion;
        this.descripcion = descripcion;
        this.precioPorNoche = precioPorNoche;
        this.reservas = new ArrayList<>();
    }

    public boolean disponibilidad(LocalDate desde, LocalDate hasta) {
        DateLapse t = new DateLapse(desde, hasta);
        return this.reservas.stream()
            .map(reserva -> reserva.getTiempo())
            .noneMatch(tiempo -> tiempo.overlaps(t));
    }

    public boolean disponibilidad(Reserva r) {
        return this.reservas.stream()
            .map(reserva -> reserva.getTiempo())
            .noneMatch(tiempo -> tiempo.overlaps(r.getTiempo()));
    }

    // Crear una reserva: Un usuario puede realizar una reserva para un período de
    // tiempo determinado. Si la propiedad está disponible, se crea la reserva y la
    // propiedad pasa a estar ocupada durante ese período. Si no lo está, la reserva no
    // será creada.
    public boolean crearReserva(Reserva r) {
        if (this.disponibilidad(r)) {
            this.reservas.add(r);
            return true;
        } else {
            return false;
        }
    }

    // Cancelar una reserva: Se debe permitir cancelar una reserva. En este caso, la
    // propiedad pasa a estar disponible durante el período de tiempo indicado en la
    // reserva.
    public boolean cancelarReserva(Reserva r) {
        if (this.reservas.contains(r)) {
            this.reservas.remove(r);
            return true;
        } else {
            return false;
        }
    }

    public double getPrecioPorNoche() {
        return this.precioPorNoche;
    }

    public Stream<Reserva> getReservas() {
        return this.reservas.stream();
    }
}
