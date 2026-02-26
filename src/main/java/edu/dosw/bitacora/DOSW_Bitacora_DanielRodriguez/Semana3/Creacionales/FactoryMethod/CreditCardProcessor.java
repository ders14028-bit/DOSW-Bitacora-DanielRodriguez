package edu.dosw.bitacora.DOSW_Bitacora_DanielRodriguez.Semana3.Creacionales.FactoryMethod;

public class CreditCardProcessor extends PaymentProcessor {

    @Override
    protected Payment createPayment() {
        return new CreditCardPayment();
    }
}

