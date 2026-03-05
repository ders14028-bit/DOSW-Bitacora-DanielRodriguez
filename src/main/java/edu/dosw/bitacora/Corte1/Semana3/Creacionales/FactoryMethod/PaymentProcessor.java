package edu.dosw.bitacora.Semana3.Creacionales.FactoryMethod;

public abstract class PaymentProcessor {


    protected abstract Payment createPayment();

    public void processPayment(double amount) {
        Payment payment = createPayment();
        payment.pay(amount);
    }
}
