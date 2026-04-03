package edu.dosw.bitacora.Corte2.Semana8.Ejercicio2;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;
import org.junit.jupiter.api.Test;

class PaymentValidationsTest {

    @Test
    void shouldValidateBalanceFraudAndTransactionLimitBoundaries() {
        BalanceValidation balance = new BalanceValidation();
        FraudValidation fraud = new FraudValidation();
        TransactionLimitValidation limit = new TransactionLimitValidation();

        assertTrue(balance.validate(request(100.0, 100.0, false, 1, 3)));
        assertFalse(balance.validate(request(120.0, 100.0, false, 1, 3)));

        assertTrue(fraud.validate(request(100.0, 200.0, false, 1, 3)));
        assertFalse(fraud.validate(request(100.0, 200.0, true, 1, 3)));

        assertTrue(limit.validate(request(100.0, 200.0, false, 2, 3)));
        assertFalse(limit.validate(request(100.0, 200.0, false, 3, 3)));
    }

    @Test
    void shouldChainValidationsAndStopOnFailure() {
        BalanceValidation first = new BalanceValidation();
        FraudValidation second = new FraudValidation();
        TransactionLimitValidation third = new TransactionLimitValidation();

        PaymentValidation returned = first.setNext(second);
        assertSame(second, returned);
        second.setNext(third);

        assertTrue(first.validate(request(100.0, 500.0, false, 1, 3)));
        assertFalse(first.validate(request(100.0, 90.0, false, 1, 3)));
    }

    private PaymentRequest request(double amount, double availableBalance, boolean fraudFlagged, int txCount, int txLimit) {
        return new PaymentRequest("cliente", amount, availableBalance, fraudFlagged, txCount, txLimit, Map.of());
    }
}

