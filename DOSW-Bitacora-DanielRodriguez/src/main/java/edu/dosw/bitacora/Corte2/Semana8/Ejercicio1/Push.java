package edu.dosw.bitacora.Corte2.Semana8.Ejercicio1;

class Push implements Notification {
    @Override
    public void send(String to, String message) {
        System.out.println("[PUSH] Para: " + to + " | Mensaje: " + message);
    }
}