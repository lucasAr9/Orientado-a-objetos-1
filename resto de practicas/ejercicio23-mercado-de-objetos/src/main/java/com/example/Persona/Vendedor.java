package com.example.Persona;

import java.util.ArrayList;
import java.util.List;

import com.example.Producto;

public class Vendedor extends Persona {
    private List<Producto> productos;

    public Vendedor(String nombre, String direccion) {
        super(nombre, direccion);
        productos = new ArrayList<>();
    }

    public void agregarProducto(Producto prod) {
        for (Producto p : this.productos) {
            if (p.getNombre().equals(prod.getNombre())) {
                p.agregarCantProducto(prod.getCantDisponible());
            }
        }
        this.productos.add(prod);
    }
}
