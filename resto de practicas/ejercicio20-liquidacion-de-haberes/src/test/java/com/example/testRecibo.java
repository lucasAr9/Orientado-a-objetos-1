package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testRecibo {
    private Empleado empleado1;
    private Empleado empleado2;
    private Empleado empleado3;
    private Empleado empleado4;
    private Contrato contratoPorHora1;
    private Contrato contratoPorHora2;
    private Contrato contratoDePlanta1;
    private Contrato contratoDePlanta2;

    @BeforeEach
    public void setUp() {
        // Empleado 1 paso por 2 contratos y el segundo sigue vigente
        contratoPorHora1 = new PorHora(LocalDate.of(2023, 1, 1), LocalDate.of(2024, 1, 1), 6000, 180);
        contratoPorHora2 = new PorHora(LocalDate.of(2024, 1, 1), LocalDate.of(2025, 1, 1), 7000, 180);
        empleado1 = new Empleado("Luis", "Pepe", 1111111111, LocalDate.of(1996, 3, 3), false);
        empleado1.agregarContrato(contratoPorHora1);
        empleado1.agregarContrato(contratoPorHora2);

        // Empleado 2 tuvo un solo contrato, el mismo que priemr contrato del empleado 1 y ya termino.
        empleado2 = new Empleado("German", "Perez", 222222222, LocalDate.of(1990, 5, 30), true);
        empleado2.agregarContrato(contratoPorHora1);

        // Empleado 3 tiene planta
        contratoDePlanta1 = new DePlanta(LocalDate.of(2023, 1, 1), 200000, 100, 100);
        empleado3 = new Empleado("ZZZ", "ZZZ", 333333333, LocalDate.of(1991, 7, 6), true);
        empleado3.agregarContrato(contratoDePlanta1);

        // Empleado 3 tuvo el mismo contrato de plata que empleado 3 pero despues le cambiaron a otro contrato de plata
        contratoDePlanta2 = new DePlanta(LocalDate.of(2024, 1, 1), 300000, 200, 200);
        empleado4 = new Empleado("EEE", "EEE", 333333333, LocalDate.of(1989, 2, 4), true);
        empleado4.agregarContrato(contratoDePlanta1);
        empleado4.agregarContrato(contratoDePlanta2);
    }

    @Test
    public void emitirRecibo() {
        assertEquals(empleado1.generarRecibo().montoCobrar(), 1260000);

        assertEquals(empleado2.generarRecibo().montoCobrar(), 0);

        assertEquals(empleado3.generarRecibo().montoCobrar(), 200200);

        assertEquals(empleado4.generarRecibo().montoCobrar(), 300400);
    }
}
