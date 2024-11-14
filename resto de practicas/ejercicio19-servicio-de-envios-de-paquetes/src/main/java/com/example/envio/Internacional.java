package com.example.envio;

import java.time.LocalDate;
import com.example.Direccion;

public class Internacional extends Envio {

    public Internacional(LocalDate fechaDespacho, Direccion direccionOrigen, Direccion direccionDestino, double peso) {
        super(fechaDespacho, direccionOrigen, direccionDestino, peso);
    }

    // Los envíos internacionales tienen un costo que depende del país destino y del peso
    // del paquete. Por ahora, utilice $5000 para cualquier destino y $10 por gramo de
    // peso para envíos de hasta 1 kg y $12 para envíos de más de 1 kg.
    @Override
    public double calcularCostoEnvio() {
        double costo = 5000;
        if (this.getPeso() <= 1000) {
            return costo + getPeso() * 10;
        } else {
            return costo + getPeso() * 12;
        }
    }
}
