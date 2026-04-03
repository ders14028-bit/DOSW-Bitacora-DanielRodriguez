package edu.dosw.bitacora.Corte2.Semana8.Ejercicio2;

final class StripeGateway {

    void charge(String token, long amountInCents) {
        System.out.println("[Stripe API] Cobro con token " + token + " por " + amountInCents + " centavos");
    }
}

