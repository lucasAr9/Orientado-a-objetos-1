package com.example.cliente;

import java.time.LocalDate;
import java.util.stream.Stream;

import com.example.Direccion;
import com.example.envio.Envio;

public class Fisico extends Cliente {
    private long dni;

    public Fisico(String nombre, Direccion direccion, long dni) {
        super(nombre, direccion);
        this.dni = dni;
    }

    public long getDni() {
        return dni;
    }

    @Override
    public double calcularMontoPagar(LocalDate desde, LocalDate hasta) {
        return super.calcularMontoPagar(desde, hasta) * 0.10;
    }
}
