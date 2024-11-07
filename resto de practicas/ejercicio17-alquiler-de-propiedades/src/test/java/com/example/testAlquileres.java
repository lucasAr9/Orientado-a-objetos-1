package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class testAlquileres {
    private Usuario usuario1;
    private Usuario usuario2;
    private Usuario usuario3;
    private Propiedad propiedad1;
    private Propiedad propiedad2;
    private Propiedad propiedad3;
    private Propiedad propiedad4;

    @BeforeEach
    public void setUp() {
        usuario1 = new Usuario("Juan Pérez", 12345678);
        usuario2 = new Usuario("María López", 23456789);
        usuario3 = new Usuario("Carlos García", 34567890);
        propiedad1 = new Propiedad("Calle Falsa 123", "Departamento acogedor en el centro de la ciudad", 75.0);
        propiedad2 = new Propiedad("Avenida Siempre Viva 742", "Casa amplia con jardín y piscina", 120.0);
        propiedad3 = new Propiedad("Plaza de Mayo 1", "Departamento frente a la plaza de Mayo", 60.0);
        propiedad4 = new Propiedad("Camino Real 45", "Cabaña en la montaña, perfecta para desconectar", 90.0);
        usuario1.agregarPropiedad(propiedad1);
        usuario2.agregarPropiedad(propiedad2);
        usuario3.agregarPropiedad(propiedad3);
        usuario3.agregarPropiedad(propiedad4);
    }

    @Test
    public void testCrearCancelarReserva() {
        // Usuario u1 reserva la propiedad 1.
        Usuario u1 = new Usuario("German", 40323430);
        LocalDate desde1 = LocalDate.of(2024, 1, 1);
        LocalDate hasta1 = LocalDate.of(2024, 1, 10);
        DateLapse tiempo1 = new DateLapse(desde1, hasta1);
        Reserva r1 = new Reserva();
        assertTrue(r1.crearReserva(u1, propiedad1, tiempo1));

        // Usuario u2 quiere reservar la propiedad 1 en la misma fecha que el u1, no puede.
        Usuario u2 = new Usuario("German", 40323430);
        LocalDate desde2 = LocalDate.of(2024, 1, 5);
        LocalDate hasta2 = LocalDate.of(2024, 1, 15);
        DateLapse tiempo2 = new DateLapse(desde2, hasta2);
        Reserva r2 = new Reserva();
        assertFalse(r2.crearReserva(u2, propiedad1, tiempo2));
        // Reserva la propiedad 1 despues de las fechas del u1.
        desde2 = LocalDate.of(2024, 1, 11);
        hasta2 = LocalDate.of(2024, 1, 15);
        tiempo2 = new DateLapse(desde2, hasta2);
        assertTrue(r2.crearReserva(u2, propiedad1, tiempo2));

        // Vemos la disponibilidad de la propiedad 1 en las fechas desde1 y hasta1 y no esta disponible.
        assertFalse(plataforma.disponibilidad(propiedad1, desde1, hasta1));
        // Pero a fin de mes y prinsipio del siguiente, si esta disponible.
        desde2 = LocalDate.of(2024, 1, 29);
        hasta2 = LocalDate.of(2024, 2, 2);
        assertTrue(plataforma.disponibilidad(propiedad1, desde2, hasta2));

        // Pero al final el Usuario u1 no puede, y cancela la reserva.
        assertTrue(plataforma.disponibilidad(propiedad1, desde1, hasta1));
    }

    @Test
    public void testCalcularCostos() {
        Usuario u1 = new Usuario("German", 40323430);
        LocalDate desde1 = LocalDate.of(2024, 1, 1);
        LocalDate hasta1 = LocalDate.of(2024, 1, 10);
        DateLapse tiempo1 = new DateLapse(desde1, hasta1);
        Reserva r1 = new Reserva();
        assertTrue(r1.crearReserva(u1, propiedad1, tiempo1));
        assertEquals(usuario1.calcularIngresos(tiempo1), 506.25);
        assertEquals(plataforma.calcularPrecio(r1), 675);
    }
}
