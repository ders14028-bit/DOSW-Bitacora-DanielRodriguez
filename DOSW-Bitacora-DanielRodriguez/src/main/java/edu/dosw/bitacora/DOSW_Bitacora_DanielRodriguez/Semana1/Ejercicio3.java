package edu.dosw.bitacora.Semana1;

import java.util.List;

//Dada una lista de usuarios con los atributos:
//id
//        name
//age
//        active
//
//Filtra unicamente los usuarios activos
//Obten una lista con los nombres en mayuscula
//Ordena alfabeticamente el resultado
//
//Datos de Entrada:  users = List<Users>
//Resultado: List<String>


public class Ejercicio3 {

    public static void main(String[] args) {

        List<User> users = List.of(
                new User(1, "Daniel", 22, true),
                new User(2, "Carlos", 25, false),
                new User(3, "Ana", 20, true),
                new User(4, "Beatriz", 30, true)
        );

        List<String> result = users.stream()
                .filter(User::isActive)
                .map(User::getName)
                .map(String::toUpperCase)
                .sorted()
                .toList();

        System.out.println(result);
    }
}
