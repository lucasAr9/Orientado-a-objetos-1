package com.example;

public class Cilindro extends Pieza {
    private int radio;
    private int altura;

    public Cilindro(String material, String color, int radio, int altura) {
        super(material, color);
        this.radio = radio;
        this.altura = altura;
    }

    // Volumen de un cilindro: π * radio^2 * h.
    public double volumen() {
        return super.getPi() * Math.pow(this.getRadio(), 2) * this.getAltura();
    }
    
    // Superficie de un cilindro: 2 * π * radio * h + 2 * π * radio^2
    public double superficie() {
        return 2 * super.getPi() * this.getRadio() * this.getAltura() + 2 * super.getPi() * Math.pow(this.getRadio(), 2);
    }
    
    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
}
