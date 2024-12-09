package com.example;

public class Humano extends Personaje {
    public Humano(String nombre, Rol rol) {
        super(nombre, rol, 2, 1);
    }

    public int poderDeAtaque(int momentoDia) {
        return momentoDia >= 8 && momentoDia <= 20 ? this.getRol().valorBase(this) * 1.40 : this.getRol().valorBase(this);
    }

    public void subirNivel() {
        this.incrementarNivel();
        if (this.getNivel() > 7) {
            this.getRol().subirNivel(this);
        }
    }
}