package edu.dosw.bitacora.DOSW_Bitacora_DanielRodriguez.Semana2.Solid.Ejercicio4;

public class Ejercicio4 {

    public static void main(String[] args) {

        Calculadora calculadora = new Calculadora();

        Operacion suma = new Suma();
        Operacion resta = new Resta();
        Operacion multiplicacion = new Multiplicacion();
        Operacion division = new Division();

        System.out.println("Suma: " + calculadora.calcular(suma, 10, 5));
        System.out.println("Resta: " + calculadora.calcular(resta, 10, 5));
        System.out.println("Multiplicación: " + calculadora.calcular(multiplicacion, 10, 5));
        System.out.println("División: " + calculadora.calcular(division, 10, 5));
    }
}

