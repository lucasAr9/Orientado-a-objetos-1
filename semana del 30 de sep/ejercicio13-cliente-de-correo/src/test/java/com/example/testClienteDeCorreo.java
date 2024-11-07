package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testClienteDeCorreo {
    private ClienteDeCorreo clienteCorreo;
    private Archivo archivo1;
    private Archivo archivo2;
    private Email e1;
    private Email e2;
    private Email e3;
    private Carpeta c1;
    private Carpeta c2;

    @BeforeEach
    void setUp() {
        this.clienteCorreo = new ClienteDeCorreo();

        archivo1 = new Archivo("archivo 1", 30);
        archivo2 = new Archivo("archivo 2", 60);
        e1 = new Email("hola1", "este es un email de pishing 1");
        e2 = new Email("hola2", "este si que es un correo real 1");
        e3 = new Email("hola3", "este si que es un correo real 2");
        c1 = new Carpeta("documentos");
        c2 = new Carpeta("pishing");

        clienteCorreo.agregarCarpeta(c1);
        clienteCorreo.agregarCarpeta(c2);
        e1.agregarAdjunto(archivo1);
        e1.agregarAdjunto(archivo2);
        clienteCorreo.recibir(e1);
        clienteCorreo.recibir(e2);
        clienteCorreo.recibir(e3);
    }

    @Test
    void testCliente() {
        // Prueba de búsqueda de emails
        assertEquals(this.clienteCorreo.buscar("hola2"), e2);
        assertEquals(this.clienteCorreo.buscar("otroquenoexiste"), null);
        
        // Prueba de espacio ocupado
        assertEquals(this.clienteCorreo.espacioOcupado(), 196);
        
        // Mover e1 de inbox a c2
        clienteCorreo.moverA(e1, c2);
        assertFalse(c1.buscarEmail(e1));  // Verificar que e1 ya no esté en c1
        assertTrue(c2.buscarEmail(e1));   // Verificar que e1 esté en c2
    }
}
