package com.example;

import java.time.LocalDate;

public class Recibo {
    private LocalDate fechaEmision;
    private Empleado empleado;
    private Contrato contrato;

    public Recibo(Empleado e, Contrato c) {
        this.empleado = e;
        this.contrato = c;
        this.fechaEmision = LocalDate.now();
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public Contrato getContrato() {
        return contrato;
    }

    // La política de la empresa determina que el porcentaje se aumente automáticamente cuando
    // se alcanza cierta antigüedad, en función de esta escala: 5 años 30%, 10 años 50%,
    // 15 años 70%, 20 años 100%. Tenga en cuenta que la antigüedad de un empleado se calcula
    // como la suma de las duraciones de cada uno de los contratos registrados.
    public double montoCobrar() {
        if (this.contrato.contratoVigente()) {
            double basico = this.getContrato().montoCobrar();
            double extra = 0;
            
            if (this.empleado.antiguedad() >= 5 && this.empleado.antiguedad() < 10) {
                extra = basico * 0.30;
            } else if (this.empleado.antiguedad() >= 10 && this.empleado.antiguedad() < 15) {
                extra = basico * 0.50;
            } else if (this.empleado.antiguedad() >= 15 && this.empleado.antiguedad() < 20) {
                extra = basico * 0.70;
            } else if (this.empleado.antiguedad() >= 20) {
                extra = basico * 0.100;
            }
            
            return basico + extra;
        }
        return 0;
    }
}
