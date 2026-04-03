package edu.dosw.bitacora.Corte2.Semana8.Ejercicio2;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

final class PaymentRequest {

    private final String customerId;
    private final double amount;
    private final double availableBalance;
    private final boolean fraudFlagged;
    private final int transactionCount;
    private final int transactionLimit;
    private final Map<String, String> metadata;

    PaymentRequest(String customerId,
                   double amount,
                   double availableBalance,
                   boolean fraudFlagged,
                   int transactionCount,
                   int transactionLimit,
                   Map<String, String> metadata) {
        this.customerId = Objects.requireNonNull(customerId, "El cliente no puede ser nulo.");
        this.amount = amount;
        this.availableBalance = availableBalance;
        this.fraudFlagged = fraudFlagged;
        this.transactionCount = transactionCount;
        this.transactionLimit = transactionLimit;
        this.metadata = new HashMap<>(Objects.requireNonNull(metadata, "Los metadatos no pueden ser nulos."));
    }

    String getCustomerId() {
        return customerId;
    }

    double getAmount() {
        return amount;
    }

    double getAvailableBalance() {
        return availableBalance;
    }

    boolean isFraudFlagged() {
        return fraudFlagged;
    }

    int getTransactionCount() {
        return transactionCount;
    }

    int getTransactionLimit() {
        return transactionLimit;
    }

    String getMetadata(String key) {
        return metadata.get(key);
    }

    Map<String, String> getMetadata() {
        return Collections.unmodifiableMap(metadata);
    }
}

