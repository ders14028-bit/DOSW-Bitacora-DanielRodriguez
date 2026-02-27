package edu.dosw.bitacora.Semana3.Estructurales.Bridge;

public abstract class Forma {

    protected Color color;

    public Forma(Color color) {
        this.color = color;
    }

    public abstract void dibujar();
}

