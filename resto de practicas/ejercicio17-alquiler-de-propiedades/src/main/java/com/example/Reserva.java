package com.example;

public class Reserva {
    private Usuario usuario;
    private Propiedad propiedad;
    private DateLapse tiempo;

    public Reserva() {
        
    }

    // Crear una reserva: Un usuario puede realizar una reserva para un período de
    // tiempo determinado. Si la propiedad está disponible, se crea la reserva y la
    // propiedad pasa a estar ocupada durante ese período. Si no lo está, la reserva no
    // será creada.
    public boolean crearReserva(Usuario user, Propiedad propiedad, DateLapse tiempo) {
        if (propiedad.agregarReserva(tiempo)) {
            this.usuario = user;
            this.propiedad = propiedad;
            this.tiempo = tiempo;
            return true;
        } else {
            return false;
        }
    }

    // Calcular el precio de una reserva: Dada una reserva, se debe poder calcular su
    // precio. El mismo se obtiene multiplicando la cantidad de noches por el precio por
    // noche.
    public double calcularPrecio() {
        return this.tiempo.sizeInDays() * this.propiedad.getPrecioPorNoche();
    }

    // Cancelar una reserva: Se debe permitir cancelar una reserva. En este caso, la
    // propiedad pasa a estar disponible durante el período de tiempo indicado en la
    // reserva.
    public boolean cancelarReserva() {
        return this.propiedad.cancelarReserva(tiempo);
    }
}
