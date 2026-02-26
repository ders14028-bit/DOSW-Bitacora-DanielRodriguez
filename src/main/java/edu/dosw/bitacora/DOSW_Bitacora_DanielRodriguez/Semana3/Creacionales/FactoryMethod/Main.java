package edu.dosw.bitacora.DOSW_Bitacora_DanielRodriguez.Semana3.Creacionales.FactoryMethod;

public class Main {

    public static void main(String[] args) {

        PaymentProcessor processor;

        processor = new CreditCardProcessor();
        processor.processPayment(100);

        processor = new PaypalProcessor();
        processor.processPayment(250);

        processor = new BankTransfererProcessor();
        processor.processPayment(500);
    }
}

