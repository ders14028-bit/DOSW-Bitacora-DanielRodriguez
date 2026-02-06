package edu.dosw.bitacora.Semana1;

import java.util.List;

//Dada una lista de transacciones bancarias representadas por objetos:
//class Transaction {
//    String id;
//    double amount;
//    boolean approved;
//}
//Se requiere procesar la lista usando Streams para:
//Usar peek para ver cada transacción procesada (Utilizar System.out.println para ver la transaccion)
//Verificar si existe al menos una transacción no aprobada
//Retornar true o false indicando si el lote de transacciones es válido.

public class Ejercicio5 {

    public static void main(String[] args) {

        List<Transaction> transactions = List.of(
                new Transaction("Transaction1", 500.0, true),
                new Transaction("Transaction2", 400.0, true),
                new Transaction("Transaction3", 300.0, false)
        );

        boolean isValid = transactions.stream()
                .peek(System.out::println)
                .noneMatch(t -> !t.isApproved());

        System.out.println("Lote valido: " + isValid);
    }
}
