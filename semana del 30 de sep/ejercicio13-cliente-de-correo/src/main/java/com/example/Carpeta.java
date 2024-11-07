package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Carpeta {
    private String nombreCarpeta;
    private List<Email> emails;

    public Carpeta(String nombre) {
        this.nombreCarpeta = nombre;
        this.emails = new ArrayList<>();
    }

    public String getNombreCarpeta() {
        return this.nombreCarpeta;
    }

    public List<Email> getEmails() {
        return this.emails;
    }

    public Stream<Email> getEmailsContexto(String texto) {
        return this.emails.stream().filter(email -> email.buscarTexto(texto));
    }

    public boolean buscarEmail(Email e) {
        return this.emails.stream().anyMatch(email -> email.equals(e));
    }

    public double tamanio() {
        return this.emails.stream().mapToDouble(email -> email.tamanioTotal()).sum();
    }

    public void agregarEmail(Email email) {
        this.emails.add(email);
    }

    public void eliminarEmail(Email email) {
        this.emails.remove(email);
    }

    public void moverA(Email email, Carpeta carpetaDestino) {
        carpetaDestino.agregarEmail(email);
        this.eliminarEmail(email);
    }
}
