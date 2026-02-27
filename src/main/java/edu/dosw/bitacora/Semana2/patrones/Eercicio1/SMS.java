package edu.dosw.bitacora.Semana2.patrones.Eercicio1;

public class SMS implements Notificacion {
    @Override
    public void enviar(String mensaje) {
        System.out.println("Enviando SMS: " + mensaje);
    }
}
