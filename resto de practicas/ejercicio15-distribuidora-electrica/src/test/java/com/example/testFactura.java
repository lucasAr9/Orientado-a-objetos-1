package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testFactura {
    Usuario usuario;
    CuadroTarifario tarifas;
    Factura factura;

    @BeforeEach
    void setUp() {
        // usuario = new Usuario("Juan", "50 y 120", 20, 5);                                              // con boni
        usuario = new Usuario("Juan", "50 y 120", 20, 15);    // sin boni
        tarifas = new CuadroTarifario(100);
        factura = new Factura(usuario, usuario.bonificacion(tarifas), usuario.costoDelConsumo(tarifas));
    }
    
    @Test
    void testEmitirFactura() {
        factura.calcularMontoFinal();
        // assertEquals(factura.getMontoFinal(), 1800);
        assertEquals(factura.calcularMontoFinal(), 2000);
    }
}
