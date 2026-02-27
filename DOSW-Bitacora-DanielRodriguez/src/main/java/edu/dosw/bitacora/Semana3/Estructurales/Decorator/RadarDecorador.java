package edu.dosw.bitacora.Semana3.Estructurales.Decorator;

public class RadarDecorador extends BarcoBaseDecorador {

    public RadarDecorador(Barco barco) {
        super(barco);
    }

    @Override
    public String getDescripcion() {
        return barco.getDescripcion() + ", Radar avanzado";
    }

    @Override
    public int poderAtaque() {
        return barco.poderAtaque() + 10;
    }
}
