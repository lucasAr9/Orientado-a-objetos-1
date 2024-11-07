package com.example;

import java.time.LocalDate;

public interface DataLapseSuprema {
    public abstract long sizeInDays();
    public abstract boolean includesDate(LocalDate other);
}
