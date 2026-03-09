package edu.dosw.bitacora.Corte2.Semana7;

import edu.dosw.bitacora.Corte2.Semana7.DOSWLearningAnalyticsSystem.Grade;
import edu.dosw.bitacora.Corte2.Semana7.DOSWLearningAnalyticsSystem.Solucion;
import edu.dosw.bitacora.Corte2.Semana7.DOSWLearningAnalyticsSystem.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SolucionTest {

    List<Student> students;

    @BeforeEach
    void setup() {

        Grade g1 = new Grade("DOSW", 5.0, LocalDate.now(), true);
        Grade g2 = new Grade("BD", 4.5, LocalDate.now(), true);
        Grade g3 = new Grade("REDES", 2.0, LocalDate.now(), false);

        Grade g4 = new Grade("DOSW", 3.0, LocalDate.now(), false);
        Grade g5 = new Grade("BD", 3.8, LocalDate.now(), true);
        Grade g6 = new Grade("REDES", 4.2, LocalDate.now(), true);

        Grade g7 = new Grade("DOSW", 4.8, LocalDate.now(), true);
        Grade g8 = new Grade("BD", 4.9, LocalDate.now(), true);

        Student s1 = new Student("1", "Ana", "AZUL", List.of(g1, g2, g3));
        Student s2 = new Student("2", "Carlos", "VERDE", List.of(g4, g5, g6));
        Student s3 = new Student("3", "Beatriz", "AZUL", List.of(g7, g8));

        students = List.of(s1, s2, s3);
    }

    // Ejercicio 1

    @Test
    void testEquipoAzul() {

        List<Student> result = Solucion.getEquipoAzul(students);

        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(s -> s.getTeam().equals("AZUL")));
    }

    // Ejercicio 2

    @Test
    void testNombresOrdenados() {

        List<String> nombres = Solucion.getNombresOrdenados(students);

        assertEquals(List.of("Ana", "Beatriz", "Carlos"), nombres);
    }

    // Ejercicio 3

    @Test
    void testPromedioGeneral() {

        double promedio = Solucion.getPromedioGeneral(students);

        assertTrue(promedio > 0);
    }

    // Ejercicio 4

    @Test
    void testPromedioPorMateria() {

        Student student = students.get(0);

        Map<String, Double> result = Solucion.promedioPorMateria(student);

        assertTrue(result.containsKey("DOSW"));
        assertTrue(result.containsKey("BD"));
        assertTrue(result.containsKey("REDES"));
    }

    // Ejercicio 5

    @Test
    void testMejorEstudiante() {

        Optional<Student> mejor = Solucion.MejorEstudiante(students);

        assertTrue(mejor.isPresent());
        assertEquals("Beatriz", mejor.get().getName());
    }

    // Ejercicio 6

    @Test
    void testReprobadasPorEquipo() {

        Map<String, Long> result = Solucion.reprobadasPorEquipo(students);

        assertTrue(result.containsKey("AZUL"));
        assertTrue(result.containsKey("VERDE"));
    }

    // Ejercicio 7

    @Test
    void testTop3Estudiantes() {

        List<Student> result = Solucion.top3Estudiantes(students);

        assertTrue(result.size() <= 3);
    }

    // Ejercicio 8

    @Test
    void testAgrupadosPorRendimiento() {

        Map<String, List<Student>> result = Solucion.agrupadosPorRendimiento(students);

        assertTrue(result.containsKey("ALTO RENDIMIENTO") ||
                result.containsKey("REGULAR") ||
                result.containsKey("RIESGO"));
    }

    // Ejercicio 9

    @Test
    void testMateriaMasDesaprobada() {

        Optional<String> result = Solucion.materaMasDesaprobada(students);

        assertTrue(result.isPresent());
    }

    // Ejercicio 10

    @Test
    void testPromedioEquipoAzul() {

        LinkedHashMap<String, Double> result = Solucion.promedioEquipoAzul(students);

        assertFalse(result.isEmpty());
    }
}

