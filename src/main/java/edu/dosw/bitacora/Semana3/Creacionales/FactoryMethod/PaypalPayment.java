package edu.dosw.bitacora.Semana3.Creacionales.FactoryMethod;

public class PaypalPayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Pago con PayPal: " + amount);
    }
}

