package edu.dosw.bitacora.Corte2.Semana8.Ejercicio2;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

final class PaymentService {

    private static final PaymentService INSTANCE = new PaymentService();

    private final Map<String, PaymentAdapter> providers = new ConcurrentHashMap<>();
    private volatile PaymentValidation validationChain;

    private PaymentService() {
        registerProvider("paypal", new PayPalAdapter(new PayPalGateway()));
        registerProvider("stripe", new StripeAdapter(new StripeGateway()));
        registerProvider("credit-card", new CreditCardAdapter(new CreditCardGateway()));
        registerProvider("bank-transfer", new BankTransferAdapter(new BankTransferGateway()));

        BalanceValidation balanceValidation = new BalanceValidation();
        FraudValidation fraudValidation = new FraudValidation();
        TransactionLimitValidation transactionLimitValidation = new TransactionLimitValidation();
        balanceValidation.setNext(fraudValidation).setNext(transactionLimitValidation);
        this.validationChain = balanceValidation;
    }

    static PaymentService getInstance() {
        return INSTANCE;
    }

    void registerProvider(String providerName, PaymentAdapter adapter) {
        providers.put(normalize(providerName), Objects.requireNonNull(adapter, "El adaptador no puede ser nulo."));
    }

    void setValidationChain(PaymentValidation validationChain) {
        this.validationChain = Objects.requireNonNull(validationChain, "La cadena de validación no puede ser nula.");
    }

    boolean validate(PaymentRequest request) {
        return currentValidationChain().validate(request);
    }

    void process(String providerName, PaymentRequest request) {
        if (!validate(request)) {
            throw new IllegalStateException("El pago fue rechazado por la cadena de validación.");
        }

        getProvider(providerName).process(request);
    }

    private PaymentValidation currentValidationChain() {
        PaymentValidation current = validationChain;
        if (current == null) {
            throw new IllegalStateException("No hay cadena de validación configurada.");
        }
        return current;
    }

    private PaymentAdapter getProvider(String providerName) {
        PaymentAdapter adapter = providers.get(normalize(providerName));
        if (adapter == null) {
            throw new IllegalArgumentException("Proveedor de pago no registrado: " + providerName);
        }
        return adapter;
    }

    private String normalize(String providerName) {
        return Objects.requireNonNull(providerName, "El proveedor no puede ser nulo.").trim().toLowerCase();
    }
}

