package com.example;

import com.example.PoliticaCancelacion.PoliticaCancelacion;

public class Reserva {
    private Usuario usuario;
    private Propiedad propiedad;
    private DateLapse tiempo;

    public Reserva(Usuario user, Propiedad propiedad, DateLapse tiempo) {
        this.usuario = user;
        this.propiedad = propiedad;
        this.tiempo = tiempo;
    }

    // Calcular el precio de una reserva: Dada una reserva, se debe poder calcular su
    // precio. El mismo se obtiene multiplicando la cantidad de noches por el precio por
    // noche.
    public double calcularPrecio() {
        return this.tiempo.sizeInDays() * this.propiedad.getPrecioPorNoche();
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public DateLapse getTiempo() {
        return tiempo;
    }
}
