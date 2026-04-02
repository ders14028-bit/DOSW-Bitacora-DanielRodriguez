package edu.dosw.bitacora.Corte2.Semana8.Ejercicio1;

class Sms implements Notification {
    @Override
    public void send(String to, String message) {
        System.out.println("[SMS] Para: " + to + " | Mensaje: " + message);
    }
}