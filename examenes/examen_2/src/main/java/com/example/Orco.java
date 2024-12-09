package com.example;

public class Orco extends Personaje {
    public Orco(String nombre, Rol rol) {
        super(nombre, rol, 1, 2);
    }
    
    public int poderDeAtaque(int momentoDia) {
        return momentoDia >= 8 && momentoDia <= 20 ? this.getRol().valorBase(this) : this.getRol().valorBase(this) * 1.60;
    }

    public void subirNivel() {
        this.incrementarNivel();
        if (this.getNivel() % 3 = 0) {
            this.getRol().subirNivel(this);
        }
    }
}