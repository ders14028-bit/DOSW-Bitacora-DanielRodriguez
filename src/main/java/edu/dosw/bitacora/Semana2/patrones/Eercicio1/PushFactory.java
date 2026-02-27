package edu.dosw.bitacora.Semana2.patrones.Eercicio1;

public class PushFactory extends NotificacionFactory {

    @Override
    public Notificacion crearNotificacion() {
        return new Push();
    }
}
