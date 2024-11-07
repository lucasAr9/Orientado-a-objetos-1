package com.example;

public class CajaDeAhorro extends Cuenta {
    private double costoAdicional;

    public CajaDeAhorro() {
        this.costoAdicional = 0.02;
    }

    public double comision(double monto) {
        return monto * this.costoAdicional;
    }

    public boolean extraer(double monto) {
        double comision = comision(monto);
        double montoFinal = monto + comision;
        return super.extraer(montoFinal);
    }

    public void depositar(double monto) {
        double comision = comision(monto);
        double montoFinal = monto - comision;
        super.depositar(montoFinal);
    }

    public boolean transferirACuenta(double monto, Cuenta cuentaDestino) {
        double comision = comision(monto);
        double montoFinal = monto + comision;
        return super.transferirACuenta(montoFinal, cuentaDestino);
    }

    protected boolean puedeExtraer(double monto) {
        return monto <= this.getSaldo();
    }
}
