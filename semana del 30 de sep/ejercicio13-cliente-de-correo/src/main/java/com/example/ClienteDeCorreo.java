package com.example;

import java.util.ArrayList;
import java.util.List;

public class ClienteDeCorreo {
    private List<Carpeta> carpetas;
    private Carpeta inbox;

    public ClienteDeCorreo() {
        this.carpetas = new ArrayList<>();
        this.inbox = new Carpeta("inbox");
        this.carpetas.add(inbox);
    }

    public void agregarCarpeta(Carpeta carpeta) {
        this.carpetas.add(carpeta);
    }

    public void recibir(Email email) {
        this.inbox.agregarEmail(email);
    }

    public void moverA(Email email, Carpeta carpetaDestino) {
        this.inbox.moverA(email, carpetaDestino);
    }

    // revisar.
    public Email buscar(String texto) {
        // return carpetas.stream()
        //     .flatMap(carpeta -> carpeta.getEmails().stream())                                         // el que tiene que saber como recorrer los emails no es esta clase, es la clase carpeta.
        //     .filter(email -> email.getTitulo().contains(texto) || email.getCuerpo().contains(texto))  // el que tiene que saber como saber si el texto esta en el email es la clase email.
        //     .findFirst()
        //     .orElse(null);
        return carpetas.stream()
            .flatMap(carpeta -> carpeta.getEmailsContexto(texto)) // el que tiene que saber como recorrer los emails no es esta clase, es la clase carpeta.
            .findFirst()
            .orElse(null);
    }

    // revisar.
    public double espacioOcupado() {
        // return carpetas.stream()
        //     .flatMap(carpeta -> carpeta.getEmails().stream())
        //     .mapToLong(email -> {
        //         long tamanioEmail = email.getTitulo().length() + email.getCuerpo().length();
        //         long tamanioArchivos = email.getArchivosAdjuntos().stream()
        //             .mapToLong(archivo -> archivo.getTamanio())
        //             .sum();
        //         return tamanioEmail + tamanioArchivos;
        //     })
        //     .sum();
        return carpetas.stream()
            .mapToDouble(carpeta -> carpeta.tamanio()) // el que tiene que saber como recorrer los emails no es esta clase, es la clase carpeta.
            .sum();
    }
}
