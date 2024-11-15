package com.example.Persona;

import java.util.ArrayList;
import java.util.List;

import com.example.Pedido;
import com.example.Producto;
import com.example.FormaDeEnvio.FormaDeEnvio;
import com.example.FormaDePago.FormaDePago;

public class Cliente extends Persona {
    private List<Pedido> pedidos;

    public Cliente(String nombre, String direccion) {
        super(nombre, direccion);
        pedidos = new ArrayList<>();
    }

    public Pedido crearPedid(FormaDePago pago, FormaDeEnvio env, Producto prod, int cantSolicitada) {
        if (prod.restarCantProducto(cantSolicitada)) {
            Pedido p = new Pedido(prod, cantSolicitada, pago, env);
            pedidos.add(p);
            return p;
        } else {
            return null;
        }
    }

    public int cantProdPedidoPorCategoria(String cat) {
        return pedidos.stream()
            .filter(producto -> producto.getProd().getCategoria().equals(cat))
            .mapToInt(producto -> producto.getCantSolicitada())
            .sum();
    }
}
