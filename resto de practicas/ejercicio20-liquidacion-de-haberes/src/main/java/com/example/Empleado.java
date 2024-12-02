package com.example;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Empleado {
    private String nombre;
    private String apellido;
    private long cuil;
    private LocalDate fechaNacimiento;
    private boolean hijos;
    private List<Contrato> contratos;

    public Empleado(String nombre, String apellido, long cuil, LocalDate fechaNacimiento, boolean hijos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cuil = cuil;
        this.fechaNacimiento = fechaNacimiento;
        this.hijos = hijos;
        this.contratos = new ArrayList<>();
    }

    public void agregarContrato(Contrato c) {
        this.contratos.add(c);
    }

    public Recibo emitirRecibo() {
        return new Recibo(this);
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public long getCuil() {
        return cuil;
    }

    public int antiguedad() {
        LocalDate fechaMin = this.contratos.stream()
                .map(fecha -> fecha.getFechaInicio())
                .min((f1, f2) -> f1.compareTo(f2))
                .orElse(null);
        return (int) ChronoUnit.YEARS.between(fechaMin, LocalDate.now());
    }

    public Contrato contratoVigente() {
        Contrato contrato = this.contratos.stream()
                .max((c1, c2) -> c1.getFechaInicio().compareTo(c2.getFechaInicio()))
                .orElse(null);
        if (contrato.esVigente()) {
            return contrato;
        } else {
            return null;
        }
    }

    // La política de la empresa determina que el porcentaje se aumente automáticamente cuando
    // se alcanza cierta antigüedad, en función de esta escala: 5 años 30%, 10 años 50%,
    // 15 años 70%, 20 años 100%. Tenga en cuenta que la antigüedad de un empleado se calcula
    // como la suma de las duraciones de cada uno de los contratos registrados.
    public double montoCobrar() {
        Contrato contrato = this.contratoVigente(); 
        if (contrato != null) {
            double extra = 1.0;
            
            if (this.antiguedad() >= 5 && this.antiguedad() < 10) {
                extra = 1.30;
            } else if (this.antiguedad() >= 10 && this.antiguedad() < 15) {
                extra = 1.50;
            } else if (this.antiguedad() >= 15 && this.antiguedad() < 20) {
                extra = 1.70;
            } else if (this.antiguedad() >= 20) {
                extra = 1.100;
            }
            
            return contrato.montoCobrar() * extra;
        }
        return 0;
    }
}
