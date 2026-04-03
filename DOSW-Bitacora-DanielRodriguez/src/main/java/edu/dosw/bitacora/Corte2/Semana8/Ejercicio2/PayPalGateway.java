package edu.dosw.bitacora.Corte2.Semana8.Ejercicio2;

final class PayPalGateway {

    void createPayment(String email, double amount) {
        System.out.println("[PayPal API] Cobro a " + email + " por $" + amount);
    }
}

