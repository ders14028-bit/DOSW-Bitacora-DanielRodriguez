package edu.dosw.bitacora.Corte2.Semana8.Ejercicio1;

class Email implements Notification {
    @Override
    public void send(String to, String message) {
        System.out.println("[EMAIL] Para: " + to + " | Mensaje: " + message);
    }
}

