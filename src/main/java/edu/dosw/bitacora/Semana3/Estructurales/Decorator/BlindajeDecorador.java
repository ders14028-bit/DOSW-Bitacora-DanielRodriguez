package edu.dosw.bitacora.Semana3.Estructurales.Decorator;

public class BlindajeDecorador extends BarcoBaseDecorador {

    public BlindajeDecorador(Barco barco) {
        super(barco);
    }

    @Override
    public String getDescripcion() {
        return barco.getDescripcion() + ", Blindaje reforzado";
    }

    @Override
    public int defensa() {
        return barco.defensa() + 30;
    }
}