package edu.dosw.bitacora.DOSW_Bitacora_DanielRodriguez.Semana3.Creacionales.FactoryMethod;

public abstract class PaymentProcessor {


    protected abstract Payment createPayment();

    public void processPayment(double amount) {
        Payment payment = createPayment();
        payment.pay(amount);
    }
}
