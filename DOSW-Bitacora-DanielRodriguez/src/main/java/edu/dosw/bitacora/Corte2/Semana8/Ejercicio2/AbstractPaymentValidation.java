package edu.dosw.bitacora.Corte2.Semana8.Ejercicio2;

abstract class AbstractPaymentValidation implements PaymentValidation {

    private PaymentValidation next;

    @Override
    public PaymentValidation setNext(PaymentValidation next) {
        this.next = next;
        return next;
    }

    @Override
    public boolean validate(PaymentRequest request) {
        return isValid(request) && (next == null || next.validate(request));
    }

    protected abstract boolean isValid(PaymentRequest request);
}

