package edu.dosw.bitacora.Corte2.Semana8.Ejercicio2;

final class CreditCardGateway {

    void debit(String cardNumber, String holder, double amount) {
        System.out.println("[Credit Card API] Cobro a la tarjeta " + cardNumber + " de " + holder + " por $" + amount);
    }
}

