package com.example.Producto;

public class Nacional extends Producto {

    public Nacional(String nombre, double costo, String descripcion) {
        super(nombre, costo, descripcion);
    }

    public double impuesto(int cant) {
        return cant < 10 ? this.getCosto() * 1.5 : this.getCosto();
    }
}
