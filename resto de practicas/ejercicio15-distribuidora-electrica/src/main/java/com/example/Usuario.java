package com.example;

public class Usuario {
    private String nombre;
    private String domicilio;
    private double consumoActivo;
    private double consumoReactivo;

    public Usuario(String nombre, String domicilio, double consumoActivo, double consumoReactivo) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.consumoActivo = consumoActivo;
        this.consumoReactivo = consumoReactivo;
    }

    // Se calcula su factor de potencia para determinar si hay alguna bonificación
    // aplicable. Si el factor de potencia estimado (fpe) del último consumo del
    // usuario es mayor a 0.8, el usuario recibe una bonificación del 10%.
    public double bonificacion(CuadroTarifario tarifa) {
        double fpe = this.getConsumoActivo() / Math.sqrt(Math.pow(this.getConsumoActivo(), 2) + Math.pow(this.getConsumoReactivo(), 2));
        if (fpe > 0.8) {
            return this.costoDelConsumo(tarifa) * 0.10; // 10% de bonificación
        }
        return 0;
    }

    // El costo del consumo se calcula multiplicando el consumo de energía activa
    // por el precio del kWh proporcionado por el cuadro tarifario.
    public double costoDelConsumo(CuadroTarifario tarifa) {
        return this.getConsumoActivo() * tarifa.getPrecioPorKWh();
    }

    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getDomicilio() {
        return domicilio;
    }
    
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
    
    public double getConsumoActivo() {
        return consumoActivo;
    }
    
    public void setConsumoActivo(double consumoActivo) {
        this.consumoActivo = consumoActivo;
    }
    
    public double getConsumoReactivo() {
        return consumoReactivo;
    }
    
    public void setConsumoReactivo(double consumoReactivo) {
        this.consumoReactivo = consumoReactivo;
    }
}
