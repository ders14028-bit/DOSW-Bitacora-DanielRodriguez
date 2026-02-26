package edu.dosw.bitacora.DOSW_Bitacora_DanielRodriguez.Semana3.Estructurales.Bridge;

public class Cuadrado extends Forma {

    public Cuadrado(Color color) {
        super(color);
    }

    @Override
    public void dibujar() {
        System.out.print("Dibujando cuadrado  ");
        color.applyColor();
    }
}

