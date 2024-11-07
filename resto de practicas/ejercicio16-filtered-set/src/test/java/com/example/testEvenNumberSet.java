package com.example;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testEvenNumberSet {
    Set<Integer> numbers;
   
    @BeforeEach
    void setUp() {
        numbers = new EvenNumberSet<Integer>();
        
        // inicialmente el Set está vacío => []
        numbers.add(1); // No es par, entonces no se agrega => []
        numbers.add(2); // Es par, se agrega al set => [2]
        numbers.add(4); // Es par, se agrega al set => [2, 4]
        numbers.add(2); // Es par, pero ya está en el set, no se agrega => [2, 4]
    }

    @Test
    void testDeNumerosPares() {
        assertFalse(numbers.contains(1));
        assertTrue(numbers.contains(2));
    }
}
