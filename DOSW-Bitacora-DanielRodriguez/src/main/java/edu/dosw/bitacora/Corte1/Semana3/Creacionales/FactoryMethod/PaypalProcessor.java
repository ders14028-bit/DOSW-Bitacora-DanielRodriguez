package edu.dosw.bitacora.Semana3.Creacionales.FactoryMethod;

public class PaypalProcessor extends PaymentProcessor {

    @Override
    protected Payment createPayment() {
        return new PaypalPayment();
    }
}

