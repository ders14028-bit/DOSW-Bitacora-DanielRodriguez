package edu.dosw.bitacora.DOSW_Bitacora_DanielRodriguez.Semana3.Estructurales.Decorator;

public class AntiTorpedosDecorador extends BarcoBaseDecorador {

    public AntiTorpedosDecorador(Barco barco) {
        super(barco);
    }

    @Override
    public String getDescripcion() {
        return barco.getDescripcion() + ", Sistema antitorpedos";
    }

    @Override
    public int poderAtaque() {
        return barco.poderAtaque() + 20;
    }
}
