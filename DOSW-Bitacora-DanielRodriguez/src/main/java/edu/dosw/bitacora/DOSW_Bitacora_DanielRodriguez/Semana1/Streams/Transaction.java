package edu.dosw.bitacora.Semana1;

class Transaction {
    String id;
    double amount;
    boolean approved;

    public Transaction(String id, double amount, boolean approved) {
        this.id = id;
        this.amount = amount;
        this.approved = approved;
    }

    public boolean isApproved() {
        return approved;
    }

}

