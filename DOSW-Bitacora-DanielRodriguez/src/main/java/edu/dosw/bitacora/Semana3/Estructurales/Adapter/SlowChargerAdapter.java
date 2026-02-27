package edu.dosw.bitacora.Semana3.Estructurales.Adapter;

public class SlowChargerAdapter implements FuelService {

    private SlowElectricCharger charger;

    public SlowChargerAdapter(SlowElectricCharger charger) {
        this.charger = charger;
    }

    @Override
    public void supply(int liters) {
        double kWh = convertLitersToKWh(liters);
        charger.slowCharge(kWh);
    }

    private double convertLitersToKWh(int liters) {
        return liters * 7.0;
    }
}

