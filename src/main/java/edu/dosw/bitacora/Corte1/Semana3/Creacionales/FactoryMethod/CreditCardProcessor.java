package edu.dosw.bitacora.Semana3.Creacionales.FactoryMethod;

public class CreditCardProcessor extends PaymentProcessor {

    @Override
    protected Payment createPayment() {
        return new CreditCardPayment();
    }
}

