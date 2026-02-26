package edu.dosw.bitacora.DOSW_Bitacora_DanielRodriguez.Semana3.Creacionales.FactoryMethod;

public class CreditCardPayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Pago con Tarjeta de Crédito: " + amount);
    }
}

