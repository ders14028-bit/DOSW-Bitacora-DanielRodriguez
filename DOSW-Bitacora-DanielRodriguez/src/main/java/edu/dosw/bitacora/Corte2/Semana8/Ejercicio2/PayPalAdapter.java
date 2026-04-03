package edu.dosw.bitacora.Corte2.Semana8.Ejercicio2;

final class PayPalAdapter implements PaymentAdapter {

    private final PayPalGateway gateway;

    PayPalAdapter(PayPalGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void process(PaymentRequest request) {
        gateway.createPayment(requireMetadata(request, "paypalEmail"), request.getAmount());
    }

    private String requireMetadata(PaymentRequest request, String key) {
        String value = request.getMetadata(key);
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Falta el dato obligatorio '" + key + "' para PayPal.");
        }
        return value;
    }
}

