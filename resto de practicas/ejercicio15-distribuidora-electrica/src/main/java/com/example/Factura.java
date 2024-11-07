package com.example;

import java.time.LocalDate;

public class Factura {
    private LocalDate fechaEmision;
    private Usuario usuario;
    private double bonificacion;
    private double costoDelConsumo;

    public Factura(Usuario u, double bonificacion, double costoDelConsumo) {
        this.usuario = u;
        this.bonificacion = bonificacion;
        this.costoDelConsumo = costoDelConsumo;
        fechaEmision = LocalDate.now();
    }
    
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public LocalDate getFechaEmision() {
        return this.fechaEmision;
    }

    // Calcular el monto final de la factura
    public double calcularMontoFinal() {
        return this.costoDelConsumo - this.bonificacion;
    }
}
