package com.example;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DataLapse {

    private LocalDate from;
    private LocalDate to;

    public DataLapse(LocalDate from, LocalDate to) {
        this.from = from;
        this.to = to;
    }

    // “Retorna la fecha de inicio del rango”
    public LocalDate getFrom() {
        return this.from;
    }

    // “Retorna la fecha de fin del rango”
    public LocalDate getTo() {
        return this.to;
    }

    // “retorna la cantidad de días entre la fecha 'from' y la fecha 'to'”
    public long sizeInDays() {
        return ChronoUnit.DAYS.between(this.from, this.to);
    }

    // “recibe un objeto LocalDate y retorna true si la fecha está entre el from y
    // el to del receptor y false en caso contrario”.
    public boolean includesDate(LocalDate other) {
        return (other.isAfter(this.getFrom()) || other.isEqual(this.getFrom()))
            && (other.isBefore(this.getTo()) || other.isEqual(this.getTo()));
    }

    // recibe un objeto DateLapse y retorna true si alguna fecha se superpone.
    public boolean overlaps(DataLapse other) {
        return !(this.to.isBefore(other.getFrom()) || this.from.isAfter(other.getTo()));
    }
}
