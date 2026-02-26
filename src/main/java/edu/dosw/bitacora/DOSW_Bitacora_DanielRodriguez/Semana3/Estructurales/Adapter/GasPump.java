package edu.dosw.bitacora.DOSW_Bitacora_DanielRodriguez.Semana3.Estructurales.Adapter;

public class GasPump implements FuelService {

    @Override
    public void supply(int liters) {
        System.out.println("Suministrando " + liters + " litros.");
    }
}
