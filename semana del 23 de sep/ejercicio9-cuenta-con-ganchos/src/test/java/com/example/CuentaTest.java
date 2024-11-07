package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CuentaTest {
    
	Cuenta juanCA, juanCC, guidoCA, guidoCC;
	
	@BeforeEach
	void setUp() throws Exception {
        juanCA = new CajaDeAhorro();
        juanCC = new CuentaCorriente();
        guidoCA = new CajaDeAhorro();
        guidoCC = new CuentaCorriente();

        juanCA.depositar(1000);
        juanCC.depositar(500);
        ((CuentaCorriente) juanCC).setLimiteDescubierto(100);
        guidoCA.depositar(800);
        guidoCC.depositar(150);
        ((CuentaCorriente) guidoCC).setLimiteDescubierto(50);
    }

    @Test
    public void testExtraer() {
        juanCA.extraer(100);
        assertEquals(juanCA.getSaldo(), 878);
        assertFalse(juanCA.extraer(1000));
        // la caja de ahorro de Juan quedo con 878

        juanCC.extraer(100);
        assertEquals(juanCC.getSaldo(), 400);
        assertFalse(juanCC.extraer(600));
        assertTrue(juanCC.extraer(500));
        // la cuenta corriente de Juan quedo en -100
    }

    @Test
    public void testTransferir() {
        assertFalse(juanCA.transferirACuenta(3000, guidoCA));
        assertFalse(juanCA.transferirACuenta(3000, guidoCC));
        assertFalse(juanCC.transferirACuenta(3000, guidoCA));
        assertTrue(juanCA.transferirACuenta(50, guidoCA));
        assertTrue(juanCA.transferirACuenta(50, guidoCC));
        juanCC.depositar(200);
        assertTrue(juanCC.transferirACuenta(50, guidoCA));
    }
}
