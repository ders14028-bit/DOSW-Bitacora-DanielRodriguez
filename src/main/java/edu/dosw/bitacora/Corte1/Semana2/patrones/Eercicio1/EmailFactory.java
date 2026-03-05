package edu.dosw.bitacora.Semana2.patrones.Eercicio1;


public class EmailFactory extends NotificacionFactory {

    @Override
    public Notificacion crearNotificacion() {
        return new Email();
    }
}
