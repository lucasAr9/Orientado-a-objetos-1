package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.Producto.Producto;

public class Distribuidora {
    private List<Cliente> clientes;

    public Distribuidora() {
        this.clientes = new ArrayList<>();
    }

    public void agregarCliente(Cliente cli) {
        if (!this.clientes.contains(cli)) {
            this.clientes.add(cli);
        }
    }

    public int calcularCantSolicitadaDeProducto(Producto prod) {
        return this.clientes.stream()
                .mapToInt(cli -> cli.cantDeProductos(prod))
                .sum();
    }

    public List<Cliente> top5() {
        return this.clientes.stream()
                .sorted((cli1, cli2) -> Double.compare(cli1.costoDeTodosSusPedidos(), cli2.costoDeTodosSusPedidos()))
                .limit(5)
                .collect(Collectors.toList());
    }
}
