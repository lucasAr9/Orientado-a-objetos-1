package com.example;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private long dni;
    private List<Propiedad> propiedades;
    
    public Usuario(String nombre, long dni) {
        this.nombre = nombre;
        this.dni = dni;
        this.propiedades = new ArrayList<>();
    }

    public boolean agregarPropiedad(Propiedad p) {
        if (!this.propiedades.contains(p)) {
            this.propiedades.add(p);
            return true;
        } else {
            return false;
        }
    }
    
    // Calcular los ingresos de un propietario: Se debe calcular la retribución a un
    // propietario, la cual es el 75% de la suma de precio totales de las reservas incluidas
    // en un período específico de tiempo.
    public double calcularIngresos(DateLapse tiempo) {
        return this.propiedades.stream()
            .flatMap(propiedad -> propiedad.getReservas())
            .filter(reserva -> reserva.getTiempo().overlaps(tiempo))
            .mapToDouble(precio -> precio.calcularPrecio())
            .sum() * 0.75;
    }    
}
