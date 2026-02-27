package edu.dosw.bitacora.Semana2.patrones.Ejercicio3;

public class Ejercicio3 {

    public static void main(String[] args) {

        Editor editor = new Editor();
        Historial historial = new Historial();

        editor.escribir("Versión 1");
        historial.guardar(editor.guardar());

        editor.escribir("Versión 2");
        historial.guardar(editor.guardar());

        editor.escribir("Versión 3");

        System.out.println("Actual: " + editor.getContenido());

        editor.restaurar(historial.obtener(1));

        System.out.println("Restaurado: " + editor.getContenido());
    }
}

