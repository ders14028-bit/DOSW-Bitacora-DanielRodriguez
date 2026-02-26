package edu.dosw.bitacora.DOSW_Bitacora_DanielRodriguez.Semana2.patrones.Eercicio1;

public class SMSFactory extends NotificacionFactory {

    @Override
    public Notificacion crearNotificacion() {
        return new SMS();
    }
}
