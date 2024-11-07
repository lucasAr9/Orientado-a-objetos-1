package com.example;

import java.util.ArrayList;
import java.util.List;

public class ReporteDeConstruccion {
    List<Pieza> piezas;

    public ReporteDeConstruccion() {
        this.piezas = new ArrayList<>();
    }

    public double volumenDeMaterial(String material) {
        return Math.round(piezas.stream()
            .filter(pieza -> pieza.checkMaterial(material))
            .mapToDouble(pieza -> pieza.volumen())
            .sum());
    }

    public double superficieDeColor(String color) {
        return Math.round(piezas.stream()
            .filter(pieza -> pieza.checkColor(color))
            .mapToDouble(pieza -> pieza.superficie())
            .sum());
    }

    public List<Pieza> getPiezas() {
        return piezas;
    }

    public void agregarPieza(Pieza p) {
        this.piezas.add(p);
    }
}
