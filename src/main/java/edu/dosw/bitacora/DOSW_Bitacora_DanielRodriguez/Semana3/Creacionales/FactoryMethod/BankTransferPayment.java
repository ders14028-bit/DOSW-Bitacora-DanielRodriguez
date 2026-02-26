package edu.dosw.bitacora.DOSW_Bitacora_DanielRodriguez.Semana3.Creacionales.FactoryMethod;

public class BankTransferPayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Pago con Transferencia Bancaria:" + amount);
    }
}

