package edu.dosw.bitacora.Corte2.Semana8.Ejercicio2;

interface PaymentValidation {
    PaymentValidation setNext(PaymentValidation next);

    boolean validate(PaymentRequest request);
}

