package com.example.envio;

import java.time.LocalDate;
import com.example.Direccion;

public class Interurbano extends Envio {
    private double km;

    public Interurbano(LocalDate fechaDespacho, Direccion direccionOrigen, Direccion direccionDestino, double peso, double km) {
        super(fechaDespacho, direccionOrigen, direccionDestino, peso);
        this.km = km;
    }

    // Los envíos interurbanos tienen un costo que depende de la distancia entre el origen
    // y el destino (utilice $20 para menos de 100 km por cada gramo de peso, $25 para
    // distancias entre 100 km y 500 km por gramo de peso, y $30 para distancias de más
    // de 500 km por gramo de peso).
    @Override
    public double calcularCostoEnvio() {
        if (this.km <= 100) {
            return this.getPeso() * 20;
        } else if (this.km > 100 && this.km <= 500) {
            return this.getPeso() * 25;
        } else {
            return this.getPeso() * 30;
        }
    }
}
