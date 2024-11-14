package com.example.envio;

import java.time.LocalDate;
import com.example.Direccion;

public class Local extends Envio {
    private boolean entregaRapida;

    public Local(LocalDate fechaDespacho, Direccion direccionOrigen, Direccion direccionDestino, double peso, boolean entregaRapida) {
        super(fechaDespacho, direccionOrigen, direccionDestino, peso);
        this.entregaRapida = entregaRapida;
    }

    // Los envíos locales tienen un costo fijo de $1000 para las entregas estándar y $500
    // adicional por entrega rápida.
    @Override
    public double calcularCostoEnvio() {
        if (this.entregaRapida) {
            return 1500;
        } else {
            return 1000;
        }
    }
}
