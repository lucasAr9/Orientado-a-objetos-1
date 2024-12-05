package com.example;

import java.time.LocalDate;
import java.util.stream.Stream;

import com.example.Bag.*;
import com.example.Producto.Producto;

public class Pedido {
    private Bag<Producto> productos;
    private LocalDate fechaDePedido;

    public Pedido() {
        this.productos = new BagImpl<>();
        this.fechaDePedido = LocalDate.now();
    }

    public void registrarProducto(Producto prod, int cant) {
        for (int i = 0; i < cant; i++) {
            this.productos.add(prod);
        }
    }

    public LocalDate getFechaDePedido() {
        return this.fechaDePedido;
    }

    public int cantDeUnProducto(Producto p) {
        return this.productos.occurrencesOf(p);
    }

    public double costoPedido() {
        return this.productos.stream()
                .mapToDouble(prod -> prod.impuesto(this.productos.occurrencesOf(prod)))
                .sum();
    }
}
