package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testReporteDeConstruccion {
    private ReporteDeConstruccion reporte;

    @BeforeEach
    void setUp() {
        // volumen 120, superficie 158
        Pieza prisma1 = new PrismaRectangular("plata", "rojo", 5, 3, 8);
        // volumen 4188.79, superficie 1256.64
        Pieza esfera1 = new Esfera("oro", "verde", 10);
        // volumen 402.12, superficie 301.59
        Pieza cilindro1 = new Cilindro("cobre", "azul", 8, 4);
        // volumen 150, superficie 190
        Pieza prisma2 = new PrismaRectangular("plata", "verde", 10, 5, 3);
        // volumen 14137.17, superficie 2827.43
        Pieza esfera2 = new Esfera("plata", "verde", 15);
        // volumen 25.13, superficie 50.27
        Pieza cilindro2 = new Cilindro("oro", "rojo", 2, 2);

        // volumen 120, superficie 158
        Pieza prisma5 = new PrismaRectangular("material", "color", 5, 3, 8);

        reporte = new ReporteDeConstruccion();
        reporte.agregarPieza(prisma1);
        reporte.agregarPieza(prisma2);
        reporte.agregarPieza(esfera1);
        reporte.agregarPieza(esfera2);
        reporte.agregarPieza(cilindro1);
        reporte.agregarPieza(cilindro2);
        reporte.agregarPieza(prisma5);
    }

    @Test
    void testReporte() {
        assertEquals(reporte.volumenDeMaterial("material"), 120);

        assertEquals(reporte.superficieDeColor("color"), 158);


        assertEquals(reporte.volumenDeMaterial("plata"), 14407);
        assertEquals(reporte.volumenDeMaterial("oro"), 4214);
        assertEquals(reporte.volumenDeMaterial("cobre"), 402);
        assertEquals(reporte.superficieDeColor("rojo"), 208);
        assertEquals(reporte.superficieDeColor("verde"), 4274);
        assertEquals(reporte.superficieDeColor("azul"), 301);

    
    }

    @Test
    void testCilindro() {
        Cilindro c = new Cilindro("cobre", "azul", 8, 4);
        assertEquals(c.volumen(), 402);
    }
}
