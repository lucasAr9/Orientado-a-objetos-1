package com.example;

public class Archivo {
    private String nombreArchivo;
    private int tamanio;

    public Archivo(String nombre, int bytes) {
        this.nombreArchivo = nombre;
        this.tamanio = bytes;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public int getTamanio() {
        return tamanio;
    }
}
