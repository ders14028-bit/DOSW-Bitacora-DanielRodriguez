package edu.dosw.bitacora.DOSW_Bitacora_DanielRodriguez.Semana3.Estructurales.Decorator;

public class BarcoBase implements Barco {

    @Override
    public String getDescripcion() {
        return "Barco base";
    }

    @Override
    public int poderAtaque() {
        return 50;
    }

    @Override
    public int defensa() {
        return 50;
    }
}
