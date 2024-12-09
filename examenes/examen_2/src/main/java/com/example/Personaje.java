package com.example;

public abstract class Personaje {
    private String nombre;
    private Rol rol;
    private int nivel;
    private int inteligencia;
    private int fuerza;

    public Personaje(String nombre, Rol rol, int inteli, int fuerza) {
        this.nombre = nombre;
        this.rol = rol;
        this.nivel = 1;
        this.inteligencia = inteli;
        this.fuerza = fuerza;
    }

    public void enfrentamiento(Personaje otroPersonaje, int momentoDia) {
        if (this.poderDeAtaque(momentoDia) > otroPersonaje.poderDeAtaque(momentoDia)) {
            this.subirNivel();
        } else if (this.poderDeAtaque(momentoDia) < otroPersonaje.poderDeAtaque(momentoDia)) {
            otroPersonaje.subirNivel();
        } else {
            this.subirNivel();
            otroPersonaje.subirNivel();
        }
    }

    public List<Personaje> buscarOponente(List<Personaje> personajes) {
        return personajes.stream()
                .filter(personaje -> this.esDiferenciaAceptable(personaje))
                .collect(Collectors.toList());
    }

    public boolean esDiferenciaAceptable(Personaje otroPersonaje) {
        int diferenciaDeNiveles = Math.abs(this.getNivel() - otroPersonaje.getNivel());
        if (diferenciaDeNiveles == 0) {
            return (Math.abs(this.poderDeAtaque(12) - otroPersonaje.poderDeAtaque(12))) < 5;
        }
        return diferenciaDeNiveles < 2;
    }

    public abstract int poderDeAtaque(int momentoDia);
    public abstract void subirNivel();

    public void cambiarRol(Rol r) {
        this.rol = r;
    }

    public void incrementarNivel() {
        this.nivel += 1;
    }

    public void subirInteligencia(int cant) {
        this.inteligencia += cant;
    }

    public void subirFuerza(int cant) {
        this.fuerza += cant;
    }

    public Rol getRol() {
        return this.rol;
    }

    public int getNivel() {
        return this.nivel;
    }

    public int getInteligencia() {
        return this.inteligencia;
    }

    public int getFuerza() {
        return this.fuerza;
    }
}