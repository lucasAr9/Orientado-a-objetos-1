package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.FormaDeEnvio.RetirarComercio;
import com.example.FormaDePago.AlContado;
import com.example.Persona.Cliente;
import com.example.Persona.Vendedor;

public class testPedidos {
    private Cliente cliente;
    private Vendedor vendedor;
    private Producto p1;
    private Producto p2;
    private Producto p3;
    
    @BeforeEach
    public void setUp() {
        vendedor = new Vendedor("Pepe", "una calle");
        p1 = new Producto("zapas niké", "ropa", 1000, 10);
        p2 = new Producto("zapas adida", "ropa", 2000, 5);
        p3 = new Producto("aifon", "celu", 500, 2);
    }
    
    @Test
    public void testVentas() {
        cliente = new Cliente("Hernan", "una calle");

        cliente.crearPedid(new AlContado(), new RetirarComercio(), p1, 5);
        assertEquals(p1.getCantDisponible(), 5);
        cliente.crearPedid(new AlContado(), new RetirarComercio(), p2, 5);
        assertEquals(p2.getCantDisponible(), 0);
        cliente.crearPedid(new AlContado(), new RetirarComercio(), p3, 5);
        assertEquals(p3.getCantDisponible(), 2);

        assertEquals(cliente.cantProdPedidoPorCategoria("ropa"), 10);
        assertEquals(cliente.cantProdPedidoPorCategoria("celu"), 0);
    }
}
