package com.example.PoliticaCancelacion;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import com.example.Reserva;

public class Moderada implements PoliticaCancelacion {
    @Override
    public double calcularReembolso(Reserva reserva) {
        long diasDeAnticipacion = ChronoUnit.DAYS.between(LocalDate.now(), reserva.getTiempo().getFrom());
        
        if (diasDeAnticipacion >= 7) {
            return reserva.calcularPrecio(); // Reembolso total si se cancela con mas de 7 dias
        } else if (diasDeAnticipacion >= 2) {
            return reserva.calcularPrecio() * 0.5; // 50% si se cancela entre 2 y 7 dias
        }
        return 0.0; // Si se cancela con menos de 2 dias de anticipación
    }
}
