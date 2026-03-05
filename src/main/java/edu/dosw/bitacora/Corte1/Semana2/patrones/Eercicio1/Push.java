package edu.dosw.bitacora.Semana2.patrones.Eercicio1;

public class Push implements Notificacion {
    @Override
    public void enviar(String mensaje) {
        System.out.println("Enviando PUSH: " + mensaje);
    }
}
