package edu.dosw.bitacora.Corte2.Semana8.Ejercicio2;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PaymentServiceTest {

    private PaymentService service;

    @BeforeEach
    void setUp() {
        service = PaymentService.getInstance();
        service.registerProvider("paypal", new PayPalAdapter(new PayPalGateway()));
        service.registerProvider("stripe", new StripeAdapter(new StripeGateway()));
        service.registerProvider("credit-card", new CreditCardAdapter(new CreditCardGateway()));
        service.registerProvider("bank-transfer", new BankTransferAdapter(new BankTransferGateway()));

        BalanceValidation balanceValidation = new BalanceValidation();
        FraudValidation fraudValidation = new FraudValidation();
        TransactionLimitValidation transactionLimitValidation = new TransactionLimitValidation();
        balanceValidation.setNext(fraudValidation).setNext(transactionLimitValidation);
        service.setValidationChain(balanceValidation);
    }

    @Test
    void shouldKeepSingletonInstance() {
        PaymentService secondReference = PaymentService.getInstance();
        assertNotNull(secondReference);
        assertTrue(service == secondReference);
    }

    @Test
    void shouldProcessWithNormalizedProviderName() {
        PaymentRequest stripeRequest = validRequest(Map.of("stripeToken", "tok_test_123"));

        PrintStream originalOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try {
            System.setOut(new PrintStream(output));
            service.process("  STRIPE  ", stripeRequest);
        } finally {
            System.setOut(originalOut);
        }

        String consoleOutput = output.toString();
        assertTrue(consoleOutput.contains("[Stripe API] Cobro con token tok_test_123 por 10000 centavos"));
    }

    @Test
    void shouldRejectWhenValidationFails() {
        PaymentRequest invalidRequest = new PaymentRequest(
                "cliente-2",
                150.0,
                50.0,
                false,
                1,
                5,
                Map.of("paypalEmail", "cliente@correo.com"));

        assertThrows(IllegalStateException.class, () -> service.process("paypal", invalidRequest));
    }

    @Test
    void shouldThrowWhenProviderIsUnknown() {
        assertThrows(IllegalArgumentException.class, () -> service.process("desconocido", validRequest(Map.of())));
    }

    @Test
    void shouldAllowRegisteringNewProvider() {
        service.registerProvider("crypto", request -> System.out.println("[Crypto API] Pago para " + request.getCustomerId()));

        PrintStream originalOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try {
            System.setOut(new PrintStream(output));
            service.process("crypto", validRequest(Map.of()));
        } finally {
            System.setOut(originalOut);
        }

        assertTrue(output.toString().contains("[Crypto API] Pago para cliente-1"));
    }

    @Test
    void shouldFailFastOnNullInputs() {
        assertThrows(NullPointerException.class, () -> service.registerProvider(null, request -> {}));
        assertThrows(NullPointerException.class, () -> service.registerProvider("nuevo", null));
        assertThrows(NullPointerException.class, () -> service.setValidationChain(null));
        assertThrows(NullPointerException.class, () -> service.process(null, validRequest(Map.of())));
    }

    @Test
    void shouldUseCustomValidationChain() {
        PaymentValidation denyAll = new PaymentValidation() {
            @Override
            public PaymentValidation setNext(PaymentValidation next) {
                return next;
            }

            @Override
            public boolean validate(PaymentRequest request) {
                return false;
            }
        };

        service.setValidationChain(denyAll);
        assertThrows(IllegalStateException.class, () -> service.process("paypal", validRequest(Map.of("paypalEmail", "cliente@correo.com"))));
    }

    private PaymentRequest validRequest(Map<String, String> metadata) {
        return new PaymentRequest(
                "cliente-1",
                100.0,
                500.0,
                false,
                2,
                5,
                new HashMap<>(metadata));
    }
}
