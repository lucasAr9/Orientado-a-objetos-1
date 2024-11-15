package com.example;

import com.example.FormaDeEnvio.FormaDeEnvio;
import com.example.FormaDePago.FormaDePago;

public class Pedido {
    private Producto prod;
    private int cantSolicitada;
    private FormaDePago pago;
    private FormaDeEnvio env;

    public Pedido(Producto prod, int cantSolicitada, FormaDePago pago, FormaDeEnvio env) {
        this.prod = prod;
        this.cantSolicitada = cantSolicitada;
        this.pago = pago;
        this.env = env;
    }

    public double calcularCosto() {
        return pago.calcularCosto(cantSolicitada, cantSolicitada) + env.calcularCosto();
    }

    public Producto getProd() {
        return prod;
    }

    public void setProd(Producto prod) {
        this.prod = prod;
    }

    public int getCantSolicitada() {
        return cantSolicitada;
    }

    public void setCantSolicitada(int cantSolicitada) {
        this.cantSolicitada = cantSolicitada;
    }

    public FormaDePago getPago() {
        return pago;
    }

    public void setPago(FormaDePago pago) {
        this.pago = pago;
    }

    public FormaDeEnvio getEnv() {
        return env;
    }

    public void setEnv(FormaDeEnvio env) {
        this.env = env;
    }
}
