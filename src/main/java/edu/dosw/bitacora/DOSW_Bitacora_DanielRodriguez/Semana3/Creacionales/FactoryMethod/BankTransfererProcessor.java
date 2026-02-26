package edu.dosw.bitacora.DOSW_Bitacora_DanielRodriguez.Semana3.Creacionales.FactoryMethod;

public class BankTransfererProcessor extends PaymentProcessor {

    @Override
    protected Payment createPayment() {
        return new BankTransferPayment();
    }
}

