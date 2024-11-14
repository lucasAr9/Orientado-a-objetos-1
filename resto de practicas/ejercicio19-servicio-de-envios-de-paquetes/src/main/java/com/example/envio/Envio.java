package com.example.envio;

import java.time.LocalDate;
import com.example.Direccion;

public abstract class Envio {
    private LocalDate fechaDespacho;
    private Direccion direccionOrigen;
    private Direccion direccionDestino;
    private double peso;
    
    public Envio(LocalDate fechaDespacho, Direccion direccionOrigen, Direccion direccionDestino, double peso) {
        this.fechaDespacho = fechaDespacho;
        this.direccionOrigen = direccionOrigen;
        this.direccionDestino = direccionDestino;
        this.peso = peso;
    }

    public boolean estaEnRango(LocalDate desde, LocalDate hasta) {
        return this.getFechaDespacho().isAfter(desde) && this.getFechaDespacho().isBefore(hasta);
    }

    // Monto a pagar por los envíos realizados dentro de un período. Se indica el cliente para
    // el cual se quiere calcular el monto y las fechas de inicio y fin del período a considerar. Para
    // calcular el monto total a pagar, se suma el costo de todos los envíos despachados durante
    // el período especificado.
    //     ● Los envíos locales tienen un costo fijo de $1000 para las entregas estándar y $500
    //     adicional por entrega rápida.
    //     ● Los envíos interurbanos tienen un costo que depende de la distancia entre el origen
    //     y el destino (utilice $20 para menos de 100 km por cada gramo de peso, $25 para
    //     distancias entre 100 km y 500 km por gramo de peso, y $30 para distancias de más
    //     de 500 km por gramo de peso).
    //     ● Los envíos internacionales tienen un costo que depende del país destino y del peso
    //     del paquete. Por ahora, utilice $5000 para cualquier destino y $10 por gramo de
    //     peso para envíos de hasta 1 kg y $12 para envíos de más de 1 kg.
    // Los envíos efectuados por personas físicas tienen un 10% de descuento.
    public abstract double calcularCostoEnvio();

    public LocalDate getFechaDespacho() {
        return fechaDespacho;
    }

    public Direccion getDireccionOrigen() {
        return direccionOrigen;
    }

    public Direccion getDireccionDestino() {
        return direccionDestino;
    }

    public double getPeso() {
        return peso;
    }
}
