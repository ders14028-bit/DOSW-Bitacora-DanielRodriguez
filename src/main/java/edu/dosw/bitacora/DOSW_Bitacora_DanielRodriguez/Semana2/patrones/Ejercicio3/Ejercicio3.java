package edu.dosw.bitacora.DOSW_Bitacora_DanielRodriguez.Semana2.patrones.Ejercicio3;

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

        // Restaurar versión 1

        editor.restaurar(historial.obtener(1));

        System.out.println("Restaurado: " + editor.getContenido());
    }
}

