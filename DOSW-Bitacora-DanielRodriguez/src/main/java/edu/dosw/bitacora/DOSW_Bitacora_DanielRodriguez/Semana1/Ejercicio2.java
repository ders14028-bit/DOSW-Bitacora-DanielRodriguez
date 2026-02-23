package edu.dosw.bitacora.Semana1;

import java.util.List;

//Dada una lista de palabras, se requiere:
//Filtrar las palabras que tengan mas de 4 caracteres
//Convertirlas en Mayusculas
//Ordenarlas alfabeticamente
//Obtener la cantidad total de palabras resultantes
//
//Datos de Entrada:
//List<String> words = List.of(“java”,”stream”,”api”,”functional”,”code”,”git”)


public class Ejercicio2 {

    public static void main(String[] args) {

        List<String> words = List.of("java","stream","api","functional","code","git");

        List<String> processed = words.stream()
                .filter(w -> w.length() > 4)
                .map(String::toUpperCase)
                .sorted()
                .toList();

        long count = processed.stream()
                        .count();

        System.out.println("Lista procesada: " + processed);
        System.out.println("Cantidad total: " + count);
    }
}

