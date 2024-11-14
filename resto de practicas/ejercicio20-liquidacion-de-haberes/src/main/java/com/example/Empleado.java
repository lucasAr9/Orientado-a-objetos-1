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
    private Contrato ultimoContrato;
    private List<Contrato> contratosPrevios;

    public Empleado(String nombre, String apellido, long cuil, LocalDate fechaNacimiento, boolean hijos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cuil = cuil;
        this.fechaNacimiento = fechaNacimiento;
        this.hijos = hijos;
        this.contratosPrevios = new ArrayList<>();
    }

    public void agregarContrato(Contrato c) {
        this.ultimoContrato = c;
        this.contratosPrevios.add(this.ultimoContrato);
    }

    public Recibo generarRecibo() {
        return new Recibo(this, this.ultimoContrato);
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
        return (int) ChronoUnit.YEARS.between(this.contratosPrevios.get(0).getFechaInicio(), LocalDate.now());
    }
}
