package edu.dosw.bitacora.Semana3.Creacionales.FactoryMethod;

public class BankTransferPayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Pago con Transferencia Bancaria:" + amount);
    }
}

