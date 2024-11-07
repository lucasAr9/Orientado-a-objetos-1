package com.example;

import java.util.ArrayList;
import java.util.List;

public class Propiedad {
    private String direccion;
    private String descripcion;
    private double precioPorNoche;
    private Usuario duenio;
    private List<DateLapse> reservas;
    
    public Propiedad(String direccion, String descripcion, double precioPorNoche) {
        this.direccion = direccion;
        this.descripcion = descripcion;
        this.precioPorNoche = precioPorNoche;
        this.reservas = new ArrayList<>();
    }

    public boolean disponibilidad(DateLapse tiempo) {
        return reservas.stream().noneMatch(reserva -> reserva.overlaps(tiempo));
    }

    public boolean agregarReserva(DateLapse tiempo) {
        if (this.disponibilidad(tiempo)) {
            this.reservas.add(tiempo);
            return true;
        } else {
            return false;
        }
    }

    public boolean cancelarReserva(DateLapse tiempo) {
        if (this.reservas.contains(tiempo)) {
            this.reservas.remove(tiempo);
            return true;
        } else {
            return false;
        }
    }

    public int getCantDiasReservados(DateLapse tiempo) {
        return reservas.stream()
            .filter(reserva -> reserva.overlaps(tiempo))
            .mapToInt(reserva -> reserva.sizeInDays())
            .sum();
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }
}
