package com.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.Producto.Producto;

public class Cliente {
    private List<Pedido> pedidos;
    private String nombre;
    private String email;
    private LocalDate fechaAlta;

    public Cliente(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
        this.fechaAlta = LocalDate.now();
        this.pedidos = new ArrayList<>();
    }

    public void registrarPedido(Pedido ped) {
        this.pedidos.add(ped);
    }

    public int cantDeProductos(Producto p) {
        return this.pedidos.stream().mapToInt(pedido -> pedido.cantDeUnProducto(p)).sum();
    }

    public double calcularCostoTotal(DataLapse fechas) {
        return this.pedidos.stream()
                .filter(pedido -> fechas.includesDate(pedido.getFechaDePedido()))
                .mapToDouble(pedido -> pedido.costoPedido())
                .sum();
    }

    public double costoDeTodosSusPedidos() {
        return this.pedidos.stream().mapToDouble(pedido -> pedido.costoPedido()).sum();
    }
}
