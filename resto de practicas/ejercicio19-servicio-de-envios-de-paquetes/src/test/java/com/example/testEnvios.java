package com.example;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import com.example.cliente.Cliente;
import com.example.cliente.Corporativo;
import com.example.cliente.Fisico;
import com.example.envio.Envio;
import com.example.envio.Internacional;
import com.example.envio.Interurbano;
import com.example.envio.Local;

public class testEnvios {
    Envio envio1;
    Envio envio2;
    Envio envio3;
    Cliente clienteFisico1;
    Cliente clienteFisico2;
    Cliente clienteCorporativo1;

    @BeforeEach
    public void setUp() {
        Direccion dir1 = new Direccion("Argentina", "1", 1000);
        Direccion dir2 = new Direccion("Argentina", "1", 1003);
        Direccion dir3 = new Direccion("Argentina", "1", 1005);
        envio1 = new Local(LocalDate.of(2024, 1, 10), dir1, new Direccion("Argentina", "1", 1001), 12, false);
        envio2 = new Interurbano(LocalDate.of(2024, 2, 20), dir2, new Direccion("Argentina", "1", 1004), 100, 90);
        envio3 = new Internacional(LocalDate.of(2024, 3, 30), dir3, new Direccion("Otro pais cualquiera", "2", 9000), 100);
        clienteFisico1 = new Fisico("Hernan", dir1, 12345678);
        clienteFisico2 = new Fisico("Juan", dir2, 12345678);
        clienteCorporativo1 = new Corporativo("Empresa", dir3, 923456789);
    }
}
