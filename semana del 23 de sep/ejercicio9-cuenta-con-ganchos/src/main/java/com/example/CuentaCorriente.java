package com.example;

public class CuentaCorriente extends Cuenta {
    private double limiteDescubierto;

    public CuentaCorriente() {
        this.limiteDescubierto = 0;
    }

    public boolean extraer(double monto) {
        return super.extraer(monto);
    }

    public boolean puedeExtraer(double monto) {
        return monto <= this.getSaldo() + this.getLimiteDescubierto();
    }

    public double getLimiteDescubierto() {
        return this.limiteDescubierto;
    }

    public void setLimiteDescubierto(double limite) {
        this.limiteDescubierto = limite;
    }
}
