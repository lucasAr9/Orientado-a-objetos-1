package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testInversion {
    private ElInversor inversor;

    private Inversion YPFC;
    private Inversion GGAL;
    private Inversion HAVA;
    private Inversion pf1;

    public void crearInversiones() {
        YPFC = new Acciones("YPF", 10, 27000);
        GGAL = new Acciones("Galicia", 25, 3400);
        HAVA = new Acciones("Havanna", 2, 6000);
        LocalDate fecha1 = LocalDate.of(2024, 9, 8);
        pf1 = new PlazoFijo(250000, 0.002, fecha1);
    }

    @BeforeEach
    void setUp() {
        inversor = new ElInversor("Juan");
        this.crearInversiones();
    }

    @Test
    void calcularCartera() {
        // Inversion YPFC = new Acciones("YPF", 10, 27000);
        // Inversion GGAL = new Acciones("Galicia", 25, 3400);
        // Inversion HAVA = new Acciones("Havanna", 2, 6000);
        // LocalDate fecha1 = LocalDate.of(2024, 9, 8);
        // Inversion pf1 = new PlazoFijo(100000, 0.002, fecha1);

        inversor.agregarInversion(YPFC);
        inversor.agregarInversion(GGAL);
        inversor.agregarInversion(HAVA);
        inversor.agregarInversion(pf1);
        assertEquals(inversor.valorActual(), 47447.80746694794);
        // solo acciones es 367000
    }
}
