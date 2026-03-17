package edu.dosw.bitacora.Semana2.patrones.Eercicio1;

public class Email implements Notificacion {
    @Override
    public void enviar(String mensaje) {
        System.out.println("Enviando EMAIL: " + mensaje);
    }
}
