package com.example;

import java.time.LocalDate;

public class DataLapse2 implements DataLapseSuprema {

    private LocalDate from;
    private long cantDias;

    public DataLapse2(LocalDate from, long cantDias) {
        this.from = from;
        this.cantDias = cantDias;
    }

    // “Retorna la fecha de inicio del rango”
    public LocalDate getFrom() {
        return this.from;
    }

    // “retorna la cantidad de días entre la fecha 'from' y la fecha 'to'”
    public long sizeInDays() {
        return this.cantDias;
    }
    
    // “Retorna la fecha de fin del rango”
    public LocalDate getTo() {
        return this.getFrom().plusDays(cantDias);
    }

    // “recibe un objeto LocalDate y retorna true si la fecha está entre el from y
    // el to del receptor y false en caso contrario”.
    public boolean includesDate(LocalDate other) {
        return (other.isAfter(this.getFrom()) || other.isEqual(this.getFrom()))
            && (other.isBefore(this.getTo()) || other.isEqual(this.getTo()));
    }
}

