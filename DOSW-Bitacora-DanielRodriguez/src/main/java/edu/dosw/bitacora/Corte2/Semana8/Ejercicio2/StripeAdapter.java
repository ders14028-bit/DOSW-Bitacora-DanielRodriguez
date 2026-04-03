package edu.dosw.bitacora.Corte2.Semana8.Ejercicio2;

final class StripeAdapter implements PaymentAdapter {

    private final StripeGateway gateway;

    StripeAdapter(StripeGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void process(PaymentRequest request) {
        gateway.charge(requireMetadata(request, "stripeToken"), Math.round(request.getAmount() * 100));
    }

    private String requireMetadata(PaymentRequest request, String key) {
        String value = request.getMetadata(key);
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Falta el dato obligatorio '" + key + "' para Stripe.");
        }
        return value;
    }
}

