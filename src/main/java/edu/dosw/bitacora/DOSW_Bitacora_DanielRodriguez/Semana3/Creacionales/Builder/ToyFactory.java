package edu.dosw.bitacora.DOSW_Bitacora_DanielRodriguez.Semana3.Creacionales.Builder;

public class ToyFactory {

    public ToyDoll constructDoll(ToyDollBuilder builder) {

        builder.buildHead();
        builder.buildBody();
        builder.buildArms();
        builder.buildLegs();
        builder.addAccessories();

        return builder.getResult();
    }
}

