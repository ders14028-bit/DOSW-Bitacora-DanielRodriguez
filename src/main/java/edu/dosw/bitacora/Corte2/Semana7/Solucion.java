package edu.dosw.bitacora.Corte2.Semana7;

import java.util.*;

import static java.util.stream.Collectors.*;

public class Solucion {

    // Ejercicio 1

    public static List<Student> getEquipoAzul(List<Student> students) {
        return students.stream()
                .filter(s -> "AZUL".equals(s.getTeam()))
                .toList();
    }

    // Ejercicio 2

    public static List<String> getNombresOrdenados(List<Student> students) {
        return students.stream()
                .map(Student::getName)
                .sorted()
                .toList();
    }


    // Ejercicio 3

    public static double getPromedioGeneral(List<Student> students) {
        return students.stream()
                .flatMap(s -> s.getGrades().stream())
                .mapToDouble(Grade::getScore)
                .average()
                .orElse(0);
    }


    // Ejercicio 4

    public static Map<String, Double> promedioPorMateria(Student student) {
        return student.getGrades().stream()
                .collect(groupingBy(
                        Grade::getSubject,
                        averagingDouble(Grade::getScore)
                ));
    }


    // Ejercicio 5

    public static Optional<Student> MejorEstudiante(List<Student> students) {
        return students.stream()
                .max(Comparator.comparingDouble(s ->
                        s.getGrades().stream()
                                .mapToDouble(Grade::getScore)
                                .average()
                                .orElse(0)
                ));
    }


    // Ejercicio 6

    public static Map<String, Long> reprobadasPorEquipo(List<Student> students) {
        return students.stream()
                .collect(groupingBy(
                        Student::getTeam,
                        flatMapping(
                                s -> s.getGrades().stream()
                                        .filter(g -> !g.isPassed()),
                                counting()
                        )
                ));
    }


    // Ejercicio 7

    public static List<Student> top3Estudiantes(List<Student> students) {

        return students.stream()
                .map(s -> Map.entry(s,
                        s.getGrades().stream()
                                .filter(Grade::isPassed)
                                .count()))
                .sorted(Map.Entry.<Student, Long>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }


    private static long approvedCount(Student s) {
        return s.getGrades().stream()
                .filter(Grade::isPassed)
                .count();
    }


    // Ejercicio 8

    private static double studentAverage(Student student) {
        return student.getGrades().stream()
                .mapToDouble(Grade::getScore)
                .average()
                .orElse(0);
    }

    public static Map<String, List<Student>> agrupadosPorRendimiento(List<Student> students) {
        return students.stream()
                .collect(groupingBy(s -> {
                    double avg = studentAverage(s);

                    if (avg >= 4.5) return "ALTO RENDIMIENTO";
                    if (avg >= 3.5) return "REGULAR";
                    return "RIESGO";
                }));
    }


    // Ejercicio 9

    public static Optional<String> materaMasDesaprobada(List<Student> students) {
        return students.stream()
                .flatMap(s -> s.getGrades().stream())
                .filter(g -> !g.isPassed())
                .collect(groupingBy(
                        Grade::getSubject,
                        counting()
                ))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
    }


    // Ejercicio 10

    public static LinkedHashMap<String, Double> promedioEquipoAzul(List<Student> students) {

        Map<String, Double> result = students.stream()
                .filter(s -> "AZUL".equals(s.getTeam()))
                .flatMap(s -> s.getGrades().stream())
                .filter(Grade::isPassed)
                .collect(groupingBy(
                        Grade::getSubject,
                        averagingDouble(Grade::getScore)
                ));

        return result.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .collect(toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a,b)->a,
                        LinkedHashMap::new
                ));
    }


}
