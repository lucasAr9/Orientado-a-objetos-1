package com.example.Rol;

public class Guerrero implements Rol {
    public int valorBase(Personaje p) {
        return (p.getFuerza() * 2) + p.getNivel() + this.getInteligencia();
    }

    public void subirNivel(Personaje p) {
        p.subirFuerza(p.getNivel() / 6);
    }
}