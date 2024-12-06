package com.example;

public class Mascota {
    private String nombre;
    private LocalDate fechaNacimiento;
    private String especie;
    private List<Servicio> servicios;

    public Mascota(String nombre, LocalDate fechaNacimiento, String especie) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.especie = especie;
        this.servicios = new ArrayList<Servicio>();
    }

    public boolean masDeCinco() {
        return this.servicios.size() >= 5;
    }

    public Vacunacion altaVacunacion(Veterinario vet, String nombreVacuna, double costoVacuna) {
        Vacunacion v = new Vacunacion(this, vet, 500, 200, nombre, costo);
        this.servicios.add(v);
        return v;
    }

    public ConsultaMedica altaConsultaMedica(Veterinario vet) {
        ConsultaMedica c = new ConsultaMedica(this, vet, 300, 200);
        this.servicios.add(c);
        return c;
    }

    public Guarderia altaGuarderia(int cantDias) {
        Guarderia g = new Guarderia(this, 10, 500);
        this.servicios.add(g);
        return g;
    }

    public double recaudacionEnDia(LocalDate fecha) {
        return this.servicios.stream()
                .filter(servicio -> servicio.getFechaAtencion().equals(fecha))
                .mapToDouble(servicio -> servicio.costo())
                .sum();
    }
}