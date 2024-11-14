package com.example;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateLapse {
    private LocalDate from;
    private LocalDate to;

    public DateLapse(LocalDate from, LocalDate to) {
        this.from = from;
        this.to = to;
    }

    public LocalDate getFrom() {
        return this.from;
    }

    public LocalDate getTo() {
        return this.to;
    }

    // retorna la cantidad de días entre la fecha 'from' y la fecha 'to'
    public int sizeInDays() {
        return (int) ChronoUnit.DAYS.between(this.from, this.to);
    }

    // recibe un objeto DateLapse y retorna true si alguna fecha se superpone.
    public boolean overlaps(DateLapse other) {
        return !(this.to.isBefore(other.getFrom()) || this.from.isAfter(other.getTo()));
    }
}
