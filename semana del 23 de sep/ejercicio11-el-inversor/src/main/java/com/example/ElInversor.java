package com.example;

import java.util.ArrayList;
import java.util.List;

public class ElInversor {
    private String nombre;
    private List<Inversion> inversiones;

    public ElInversor(String nombre) {
        this.nombre = nombre;
        this.inversiones = new ArrayList<Inversion>();
    }

    public double valorActual() {
        return this.inversiones.stream().mapToDouble(inversion -> inversion.valorActual()).sum();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Inversion> getInversiones() {
        return inversiones;
    }

    public void agregarInversion(Inversion inversion) {
        this.inversiones.add(inversion);
    }
}
