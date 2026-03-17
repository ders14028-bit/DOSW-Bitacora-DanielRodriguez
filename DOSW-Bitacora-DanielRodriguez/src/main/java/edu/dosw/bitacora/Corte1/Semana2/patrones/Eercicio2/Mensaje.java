package edu.dosw.bitacora.Semana2.patrones.Eercicio2;

import java.time.LocalDate;

public class Mensaje {

    private String texto;
    private String autor;
    private LocalDate fecha;

    public Mensaje(String texto, String autor, LocalDate fecha) {
        this.texto = texto;
        this.autor = autor;
        this.fecha = fecha;
    }

    public String getTexto() {
        return texto;
    }

    public String getAutor() {
        return autor;
    }

    public LocalDate getFecha() {
        return fecha;
    }
}

