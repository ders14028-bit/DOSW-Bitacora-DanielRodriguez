package edu.dosw.bitacora.DOSW_Bitacora_DanielRodriguez.Semana3.Estructurales.Decorator;

public class MisilesDecorador extends BarcoBaseDecorador {

    public MisilesDecorador(Barco barco) {
        super(barco);
    }

    @Override
    public String getDescripcion() {
        return barco.getDescripcion() + ", Misiles";
    }

    @Override
    public int poderAtaque() {
        return barco.poderAtaque() + 40;
    }
}
