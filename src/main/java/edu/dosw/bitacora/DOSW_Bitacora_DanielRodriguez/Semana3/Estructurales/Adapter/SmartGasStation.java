package edu.dosw.bitacora.DOSW_Bitacora_DanielRodriguez.Semana3.Estructurales.Adapter;

public class SmartGasStation {

    public static void main(String[] args) {

        FuelService gasolinePump = new GasPump();

        FuelService fastElectricalAdapter =
                new FastChargerAdapter(new FastElectricCharger());

        FuelService slowElectricalAdapter =
                new SlowChargerAdapter(new SlowElectricCharger());

        gasolinePump.supply(30);
        fastElectricalAdapter.supply(30);
        slowElectricalAdapter.supply(30);
    }
}
