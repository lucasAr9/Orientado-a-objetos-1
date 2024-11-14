package com.example.PoliticaCancelacion;

import java.time.LocalDate;
import com.example.Reserva;

public class Flexible implements PoliticaCancelacion {
    @Override
    public double calcularReembolso(Reserva reserva) {
        if (LocalDate.now().isBefore(reserva.getTiempo().getFrom())) {
            return reserva.calcularPrecio();
        }
        return 0.0;
    }
}
