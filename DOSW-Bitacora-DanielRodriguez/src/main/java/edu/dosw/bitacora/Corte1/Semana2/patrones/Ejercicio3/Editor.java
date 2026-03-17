package edu.dosw.bitacora.Semana2.patrones.Ejercicio3;

public class Editor {

    private String contenido;

    public Editor() {
        this.contenido = "";
    }

    public void escribir(String texto) {
        this.contenido = texto;
    }

    public String getContenido() {
        return contenido;
    }

    // Crear snapshot

    public Memento guardar() {
        return new Memento(contenido);
    }

    // Restaurar snapshot

    public void restaurar(Memento memento) {
        this.contenido = memento.getEstado();
    }

    // Clase interna Memento

    public static class Memento {

        private final String estado;

        private Memento(String estado) {
            this.estado = estado;
        }

        private String getEstado() {
            return estado;
        }
    }
}

