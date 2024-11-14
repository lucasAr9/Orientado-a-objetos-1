package com.example.PoliticaCancelacion;

import com.example.Reserva;

public class Estricta implements PoliticaCancelacion {
    @Override
    public double calcularReembolso(Reserva reserva) {
        return 0.0;
    }
}
