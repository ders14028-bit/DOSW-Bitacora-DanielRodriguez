package edu.dosw.bitacora.Corte2.Semana8.Ejercicio2;

final class BankTransferAdapter implements PaymentAdapter {

    private final BankTransferGateway gateway;

    BankTransferAdapter(BankTransferGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void process(PaymentRequest request) {
        gateway.transfer(requireMetadata(request, "bankAccount"), requireMetadata(request, "bankName"), request.getAmount());
    }

    private String requireMetadata(PaymentRequest request, String key) {
        String value = request.getMetadata(key);
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Falta el dato obligatorio '" + key + "' para transferencia bancaria.");
        }
        return value;
    }
}

