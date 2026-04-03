package edu.dosw.bitacora.Corte2.Semana8.Ejercicio2;

final class BankTransferGateway {

    void transfer(String accountNumber, String bankName, double amount) {
        System.out.println("[Bank Transfer API] Transferencia desde " + bankName + " / cuenta " + accountNumber + " por $" + amount);
    }
}

