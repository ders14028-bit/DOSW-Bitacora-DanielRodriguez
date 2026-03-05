package edu.dosw.bitacora.Semana3.Estructurales.Adapter;

public class GasPump implements FuelService {

    @Override
    public void supply(int liters) {
        System.out.println("Suministrando " + liters + " litros.");
    }
}
