package edu.dosw.bitacora.Corte2.Semana8.Ejercicio2;

final class CreditCardAdapter implements PaymentAdapter {

    private final CreditCardGateway gateway;

    CreditCardAdapter(CreditCardGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void process(PaymentRequest request) {
        gateway.debit(requireMetadata(request, "cardNumber"), requireMetadata(request, "cardHolder"), request.getAmount());
    }

    private String requireMetadata(PaymentRequest request, String key) {
        String value = request.getMetadata(key);
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Falta el dato obligatorio '" + key + "' para tarjeta de crédito.");
        }
        return value;
    }
}

