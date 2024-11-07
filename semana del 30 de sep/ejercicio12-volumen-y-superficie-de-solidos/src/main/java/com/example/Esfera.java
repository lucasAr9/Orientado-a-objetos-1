package com.example;

public class Esfera extends Pieza {
    private int radio;

    public Esfera(String material, String color, int radio) {
        super(material, color);
        this.radio = radio;
    }

    // Volumen de una esfera: 4/3 * π * radio^3.
    public double volumen () {
        return (4.0 / 3.0) * super.getPi() * Math.pow(this.getRadio(), 3);
    }

    // Superficie de una esfera: 4 * π * radio^2
    public double superficie() {
        return 4 * super.getPi() * Math.pow(this.getRadio(), 2);
    }
    
    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }
}
