package com.example.cliente;

import java.time.LocalDate;
import com.example.Direccion;

public class Corporativo extends Cliente {
    private long cuit;

    public Corporativo(String nombre, Direccion direccion, long cuit) {
        super(nombre, direccion);
        this.cuit = cuit;
    }

    public long getCuit() {
        return cuit;
    }
}
