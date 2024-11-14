package com.example.cliente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import com.example.Direccion;
import com.example.envio.Envio;

public abstract class Cliente {
    private String nombre;
    private Direccion direccion;
    private List<Envio> envios;

    public Cliente(String nombre, Direccion direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.envios = new ArrayList<>();
    }

    public void agregarEnvio(Envio envio) {
        this.envios.add(envio);
    }

    public void eliminarEnvio(Envio envio) {
        this.envios.remove(envio);
    }

    public String getNombre() {
        return nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public Stream<Envio> envios() {
        return this.envios.stream();
    }

    // Monto a pagar por los envíos realizados dentro de un período. Se indica el cliente para
    // el cual se quiere calcular el monto y las fechas de inicio y fin del período a considerar. Para
    // calcular el monto total a pagar, se suma el costo de todos los envíos despachados durante
    // el período especificado.
    // Los envíos efectuados por personas físicas tienen un 10% de descuento.

    public double calcularMontoPagar(LocalDate desde, LocalDate hasta) {
        return this.envios()
            .filter(envio -> envio.estaEnRango(desde, hasta))
            .mapToDouble(envio -> envio.calcularCostoEnvio())
            .sum();
    }
}
