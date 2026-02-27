package edu.dosw.bitacora.Semana1.Streams;

import java.util.List;

//Dada una lista de numeros enteros, necesitamos obtener una nueva lista solo con los numeros pares mayores a diez
//
//Datos de Entrada:
//List<Integer> numbers = List.of(3,8,10,12,15,18,20)
//Resultado:
//List<Integer>


public class Ejercicio1 {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(3, 8, 10, 12, 15, 18, 20);

        List<Integer> result = numbers.stream()
                .filter(n -> n % 2 == 0)
                .filter(n -> n > 10)
                .toList();

        System.out.println(result);
    }
}


