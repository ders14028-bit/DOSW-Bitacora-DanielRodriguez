package edu.dosw.bitacora.Semana3.Creacionales.FactoryMethod;

public class CreditCardPayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Pago con Tarjeta de Crédito: " + amount);
    }
}

