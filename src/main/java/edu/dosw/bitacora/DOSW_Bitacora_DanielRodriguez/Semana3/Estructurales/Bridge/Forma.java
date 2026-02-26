package edu.dosw.bitacora.DOSW_Bitacora_DanielRodriguez.Semana3.Estructurales.Bridge;

public abstract class Forma {

    protected Color color;

    public Forma(Color color) {
        this.color = color;
    }

    public abstract void dibujar();
}

