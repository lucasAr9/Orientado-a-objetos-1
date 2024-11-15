package com.example;

public class Producto {
    private String nombre;
    private String categoria;
    private double precio;
    private int cantDisponible;
    
    public Producto(String nombre, String categoria, double precio, int cantDisponible) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.cantDisponible = cantDisponible;
    }

    public boolean restarCantProducto(int cant) {
        if (this.getCantDisponible() >= cant) {
            this.cantDisponible -= cant;
            return true;
        } else {
            return false;
        }
    }

    public void agregarCantProducto(int cant) {
        this.cantDisponible += cant;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getCategoria() {
        return categoria;
    }
    
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    public double getPrecio() {
        return precio;
    }
    
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public int getCantDisponible() {
        return cantDisponible;
    }

    public void setCantDisponible(int cantDisponible) {
        this.cantDisponible = cantDisponible;
    }
}
