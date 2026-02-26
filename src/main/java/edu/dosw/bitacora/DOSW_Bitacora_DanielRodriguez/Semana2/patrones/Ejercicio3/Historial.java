package edu.dosw.bitacora.DOSW_Bitacora_DanielRodriguez.Semana2.patrones.Ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class Historial {

    private List<Editor.Memento> historial = new ArrayList<>();

    public void guardar(Editor.Memento memento) {
        historial.add(memento);
    }

    public Editor.Memento obtener(int indice) {
        return historial.get(indice);
    }
}
