package com.example;

import java.util.ArrayList;
import java.util.List;

public class Email {
    private String titulo;
    private String cuerpo;
    private List<Archivo> archivosAdjuntos;

    public Email(String titulo, String cuerpo) {
        this.titulo = titulo;
        this.cuerpo = cuerpo;
        this.archivosAdjuntos = new ArrayList<>();
    }

    public Boolean buscarTexto(String texto) {
        return this.getTitulo().contains(texto) || this.getCuerpo().contains(texto);
    }

    public double tamanioTotal() {
        long tamanioEmail = this.getTitulo().length() + this.getCuerpo().length();
        long tamanioArchivos = this.getArchivosAdjuntos().stream()
            .mapToLong(archivo -> archivo.getTamanio())
            .sum();
        return tamanioEmail + tamanioArchivos;
    }

    public void agregarAdjunto(Archivo archivo) {
        this.archivosAdjuntos.add(archivo);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public List<Archivo> getArchivosAdjuntos() {
        return archivosAdjuntos;
    }
}
