package com.example.Evento;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.Sede;

public class Presencial extends Evento {
    private List<Sede> sedes;
    
    public Presencial(String nombre, LocalDate fecha, String temaPrincipal, double precioInscripcion, double precioRemera, double montoPorEnvio) {
        super(nombre, fecha, temaPrincipal, precioInscripcion, precioRemera);
        this.sedes = new ArrayList<Sede>();
    }

    public double costoDelEvento() {
        double costoSedes = this.sedes.stream().mapToDouble(sede -> sede.calcularCosto()).sum();
        return this.getPrecioInscripcion() + this.getPrecioRemera() + costoSedes;
    }
}
