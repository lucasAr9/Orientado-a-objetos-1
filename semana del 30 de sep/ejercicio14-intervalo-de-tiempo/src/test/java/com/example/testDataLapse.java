package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testDataLapse {
    DataLapseSuprema lapso;

    @BeforeEach
    public void setUp() {
        LocalDate fechaFrom = LocalDate.of(2022, 1, 1);
        // Para DataLapse
        LocalDate fechaTo = LocalDate.of(2023, 1, 1);
        lapso = new DataLapse(fechaFrom, fechaTo);
        // Para DataLapse2
        long cant = 365;
        lapso = new DataLapse2(fechaFrom, cant);
    }

    @Test
    public void testLapso() {
        assertEquals(lapso.sizeInDays(), 365);

        // fechas random
        LocalDate other = LocalDate.of(2022, 10, 23);
        assertTrue(lapso.includesDate(other));
        LocalDate other2 = LocalDate.of(2024, 10, 23);
        assertFalse(lapso.includesDate(other2));

        // fechas limites
        LocalDate limite1 = LocalDate.of(2022, 1, 1);
        assertTrue(lapso.includesDate(limite1));
        LocalDate limite2 = LocalDate.of(2023, 1, 1);
        assertTrue(lapso.includesDate(limite2));
    }
}
