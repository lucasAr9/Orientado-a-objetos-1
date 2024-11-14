package com.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import com.example.PoliticaCancelacion.PoliticaCancelacion;

public class Propiedad {
    private String direccion;
    private String descripcion;
    private double precioPorNoche;
    private List<Reserva> reservas;
    private PoliticaCancelacion politicaCancelacion;
    
    public Propiedad(String direccion, String descripcion, double precioPorNoche, PoliticaCancelacion politicaCancelacion) {
        this.direccion = direccion;
        this.descripcion = descripcion;
        this.precioPorNoche = precioPorNoche;
        this.reservas = new ArrayList<>();
        this.politicaCancelacion = politicaCancelacion;
    }

    public boolean disponibilidad(LocalDate desde, LocalDate hasta) {
        DateLapse t = new DateLapse(desde, hasta);
        return this.reservas.stream()
            .noneMatch(reserva -> reserva.getTiempo().overlaps(t));
    }


    public boolean disponibilidad(DateLapse t) {
        return this.reservas.stream()
            .noneMatch(reserva -> reserva.getTiempo().overlaps(t));
    }

    public boolean disponibilidad(Reserva r) {
        return this.disponibilidad(r.getTiempo());
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
    public double cancelarReserva(Reserva r) {
        DateLapse t = new DateLapse(LocalDate.now(), LocalDate.now());
        if (this.reservas.contains(r) && !r.getTiempo().overlaps(t)) {
            this.reservas.remove(r);
            return this.getPoliticaCancelacion().calcularReembolso(r);
        }
        return 0;
    }

    public double getPrecioPorNoche() {
        return this.precioPorNoche;
    }

    public Stream<Reserva> getReservas() {
        return this.reservas.stream();
    }

    public PoliticaCancelacion getPoliticaCancelacion() {
        return politicaCancelacion;
    }
}
