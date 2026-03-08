# SEMANA 1 - DESAFIO DE CODIGO

---

Para esta semana inicial de refuerzo van a tener como primera actividad la siguiente: Ejercicios de Progracion funcional y Pruebas unitarias

- Requisitos obligatorios:

 1. Prohibido usar ciclos for o while.

 2. Uso correcto de las funciones que los streams les proveen

 3. Implementar pruebas unitarias con una cobertura mínima: 80%.

 4. Proyecto estructurado con Apache Maven

 5. Se debe trabajar bajo flujo profesional con Git Flow manejando sus ramas adecuadamente, recuerden generarlas por semana y mezclarlas todas a develop

- No se permiten:

 1. Commits masivos sin descripción.

 2. Push directo a main.

 3. Código sin pruebas.

---

# EJERCICIOS - DOSW Learning Analytics System

- DOSW Company quiere analizar el rendimiento académico de sus “colaboradores en período de prueba”.

  - Se tiene el siguiente modelo:

        class Student {
            String id;
            String name;
            String team; // "DORADO", "AZUL", "VERDE"
            List<Grade> grades;
        }

        class Grade {
            String subject; // "DOSW", "BD", "REDES"
            double score;
            LocalDate date;
            boolean passed;
        }

1. Obtener todos los estudiantes del equipo AZUL -> Retornar una lista de estudiantes cuyo team sea AZUL

2. Obtener todos los nombres de estudiantes ordenados Alfabeticamente

3. Calcular el promedio general de todos los score existentes en el sistema

4. Retornar por estudiante el primedio por materia -> Retornar un Map<String, Double> donde la clave es la materia y el valor el promedio

5. Retornar el estudiante cuyo promedio general sea el mas alto del curso

6. Retornar las materias reprobadas por equipo -> Retornar Map <String, Long> donde la clave es el nombre del equipo y el valor la cantidad total de materias reprobadas

7. Top 3 estudiantes con mas materias aprobadas -> Retornar lista ordenada de manera descendente

8. Agrupar estudiantes por estado academico: Clasificarlos por ALTO RENDIMIENTO -> Promedio >=4,5 , REGULAR -> Promedio entre 3,5 y 4.49, RIESGO -> promedio < 3,5

9. Obtener la materia con mas reprobaciones

10. Tome solo estudiantes del equipo AZUL, Obtenga todas sus notas, Filtre solo notas aprobadas, Agrupe por materia, Calcule promedio por materia, Ordene descendente por promedio, Retorne un LinkedHashMap preservando orden.