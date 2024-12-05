package com.example.Producto;

public class Internacional extends Producto {
    private String paisOrigen;

    public Internacional(String nombre, double costo, String descripcion, String pais) {
        super(nombre, costo, descripcion);
        this.paisOrigen = pais;
    }

    public double impuesto(int cant) {
        return this.esMercosur() && cant > 50 ? this.getCosto() * 1.8 : this.getCosto() * 1.21;
    }

    public String getPaisOrigen() {
        return this.paisOrigen;
    }

    public boolean esMercosur() {
        return this.getPaisOrigen() == "Brazil" || this.getPaisOrigen() == "Paraguay" || this.getPaisOrigen() == "Uruguay";
    }
}
