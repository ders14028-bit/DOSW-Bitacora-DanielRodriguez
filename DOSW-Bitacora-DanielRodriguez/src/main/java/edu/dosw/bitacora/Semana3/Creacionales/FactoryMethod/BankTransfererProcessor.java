package edu.dosw.bitacora.Semana3.Creacionales.FactoryMethod;

public class BankTransfererProcessor extends PaymentProcessor {

    @Override
    protected Payment createPayment() {
        return new BankTransferPayment();
    }
}

