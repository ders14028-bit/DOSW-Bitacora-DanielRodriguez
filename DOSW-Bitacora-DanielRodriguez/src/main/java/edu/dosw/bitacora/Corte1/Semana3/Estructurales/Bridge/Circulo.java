package edu.dosw.bitacora.Semana3.Estructurales.Bridge;

public class Circulo extends Forma {

    public Circulo(Color color) {
        super(color);
    }

    @Override
    public void dibujar() {
        System.out.print("Dibujando círculo  ");
        color.applyColor();
    }
}

