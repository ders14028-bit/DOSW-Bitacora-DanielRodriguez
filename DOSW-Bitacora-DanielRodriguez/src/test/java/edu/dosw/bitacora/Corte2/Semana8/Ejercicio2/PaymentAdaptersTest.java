package edu.dosw.bitacora.Corte2.Semana8.Ejercicio2;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;
import org.junit.jupiter.api.Test;

class PaymentAdaptersTest {

    @Test
    void shouldProcessAllBuiltInAdapters() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try {
            System.setOut(new PrintStream(output));

            new PayPalAdapter(new PayPalGateway()).process(request(Map.of("paypalEmail", "pay@correo.com")));
            new StripeAdapter(new StripeGateway()).process(request(Map.of("stripeToken", "tok_abc")));
            new CreditCardAdapter(new CreditCardGateway()).process(request(Map.of("cardNumber", "4111111111111111", "cardHolder", "Ana")));
            new BankTransferAdapter(new BankTransferGateway()).process(request(Map.of("bankAccount", "12345", "bankName", "Banco Demo")));
        } finally {
            System.setOut(originalOut);
        }

        String text = output.toString();
        assertTrue(text.contains("[PayPal API] Cobro a pay@correo.com por $100.0"));
        assertTrue(text.contains("[Stripe API] Cobro con token tok_abc por 10000 centavos"));
        assertTrue(text.contains("[Credit Card API] Cobro a la tarjeta 4111111111111111 de Ana por $100.0"));
        assertTrue(text.contains("[Bank Transfer API] Transferencia desde Banco Demo / cuenta 12345 por $100.0"));
    }

    @Test
    void shouldFailWhenPayPalMetadataIsMissingOrBlank() {
        PayPalAdapter adapter = new PayPalAdapter(new PayPalGateway());
        assertThrows(IllegalArgumentException.class, () -> adapter.process(request(Map.of())));
        assertThrows(IllegalArgumentException.class, () -> adapter.process(request(Map.of("paypalEmail", "   "))));
    }

    @Test
    void shouldFailWhenStripeMetadataIsMissingOrBlank() {
        StripeAdapter adapter = new StripeAdapter(new StripeGateway());
        assertThrows(IllegalArgumentException.class, () -> adapter.process(request(Map.of())));
        assertThrows(IllegalArgumentException.class, () -> adapter.process(request(Map.of("stripeToken", ""))));
    }

    @Test
    void shouldFailWhenCardMetadataIsMissingOrBlank() {
        CreditCardAdapter adapter = new CreditCardAdapter(new CreditCardGateway());
        assertThrows(IllegalArgumentException.class, () -> adapter.process(request(Map.of("cardHolder", "Ana"))));
        assertThrows(IllegalArgumentException.class, () -> adapter.process(request(Map.of("cardNumber", "4111111111111111", "cardHolder", "  "))));
    }

    @Test
    void shouldFailWhenBankTransferMetadataIsMissingOrBlank() {
        BankTransferAdapter adapter = new BankTransferAdapter(new BankTransferGateway());
        assertThrows(IllegalArgumentException.class, () -> adapter.process(request(Map.of("bankName", "Banco"))));
        assertThrows(IllegalArgumentException.class, () -> adapter.process(request(Map.of("bankAccount", "12345", "bankName", ""))));
    }

    private PaymentRequest request(Map<String, String> metadata) {
        return new PaymentRequest("cliente", 100.0, 500.0, false, 1, 5, metadata);
    }
}

