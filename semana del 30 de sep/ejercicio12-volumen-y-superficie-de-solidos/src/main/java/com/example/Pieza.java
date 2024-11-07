package com.example;

public abstract class Pieza {
    private String material;
    private String color;
    private double pi = Math.PI;

    public Pieza(String material, String color) {
        this.material = material;
        this.color = color;
    }

    public abstract double volumen();

    public abstract double superficie();

    public Boolean checkMaterial(String material) {
        return this.material.equals(material);
    }

    public Boolean checkColor(String color) {
        return this.color.equals(color);
    }

    public String getMaterial() {
        return material;
    }
    
    public void setMaterial(String material) {
        this.material = material;
    }
    
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public double getPi() {
        return pi;
    }
}
