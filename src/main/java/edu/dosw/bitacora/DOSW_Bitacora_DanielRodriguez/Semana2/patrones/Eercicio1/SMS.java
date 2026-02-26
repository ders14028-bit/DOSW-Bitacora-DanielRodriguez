package edu.dosw.bitacora.DOSW_Bitacora_DanielRodriguez.Semana2.patrones.Eercicio1;

public class SMS implements Notificacion {
    @Override
    public void enviar(String mensaje) {
        System.out.println("Enviando SMS: " + mensaje);
    }
}
