package edu.dosw.bitacora.Corte2.Semana7;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import java.util.List;

public class Student {
    private String id;
    private String name;
    private String team;
    private List<Grade> grades;

    public Student(String id, String name, String team, List<Grade> grades) {
        this.id = id;
        this.name = name;
        this.team = team;
        this.grades = grades;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public List<Grade> getGrades() {
        return grades;
    }
}

