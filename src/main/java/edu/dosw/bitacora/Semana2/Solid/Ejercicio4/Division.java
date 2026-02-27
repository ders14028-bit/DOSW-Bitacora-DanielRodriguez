package edu.dosw.bitacora.Semana2.Solid.Ejercicio4;

public class Division implements Operacion {

    @Override
    public double ejecutar(double a, double b) {

        if (b == 0) {
            throw new ArithmeticException("No se puede dividir entre 0");
        }

        return a / b;
    }
}

