package edu.dosw.bitacora.DOSW_Bitacora_DanielRodriguez.Semana2.patrones.Eercicio1;

public class Ejercicio1 {

    public static void main(String[] args) {

        NotificacionFactory factory = new SMSFactory();
        Notificacion notificacion = factory.crearNotificacion();
        notificacion.enviar("Hola");

    }
}


