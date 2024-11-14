package com.example;

public class Direccion {
    private String pais;
    private String calle;
    private int numero;

    public Direccion(String pais, String calle, int numero) {
        this.pais = pais;
        this.calle = calle;
        this.numero = numero;
    }

    public String getPais() {
        return pais;
    }

    public String getCalle() {
        return calle;
    }

    public int getNumero() {
        return numero;
    }
}
