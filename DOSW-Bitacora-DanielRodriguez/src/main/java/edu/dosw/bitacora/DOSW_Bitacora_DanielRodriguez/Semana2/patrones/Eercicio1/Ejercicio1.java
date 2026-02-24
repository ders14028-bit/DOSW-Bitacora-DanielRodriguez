package edu.dosw.bitacora.DOSW_Bitacora_DanielRodriguez.Semana2.patrones.Eercicio1;

import io.jooby.internal.email.EmailFactory;

public class Ejercicio1 {

    public static void main(String[] args) {

        NotificacionFactory factory = new EmailFactory();
        Notificacion notificacion = factory.crearNotificacion();
        notificacion.enviar("Hola");

    }
}


