package com.example.Rol;

public class Mago implements Rol {
    public int valorBase(Personaje p) {
        return (p.getInteligencia() + p.getNivel()) * 2;
    }

    public void subirNivel(Personaje p) {
        p.subirInteligencia(3/2 * p.getNivel());
    }
}