package edu.dosw.bitacora.Corte2.Semana8.Ejercicio2;

final class TransactionLimitValidation extends AbstractPaymentValidation {

    @Override
    protected boolean isValid(PaymentRequest request) {
        return request.getTransactionCount() < request.getTransactionLimit();
    }
}

