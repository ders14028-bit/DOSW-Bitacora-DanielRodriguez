package edu.dosw.bitacora.Semana1.Streams;

//Dado un listado de Usuarios y utilizando los mismo atributos anteriores,
//filtrar las personas mayores de edad y obtener sus nombres.

import java.util.List;

public class Ejercicio4 {

    public static void main(String[] args) {

        List<User> users = List.of(
                new User(1, "Daniel", 22, true),
                new User(2, "Carlos", 25, false),
                new User(3, "Ana", 20, true),
                new User(4, "Beatriz", 30, true)
        );

        List<String> result = users.stream()
                .filter(u -> u.getAge() > 18)
                .map(User::getName)
                .map(String::toUpperCase)
                .sorted()
                .toList();

        System.out.println(result);
    }
}
