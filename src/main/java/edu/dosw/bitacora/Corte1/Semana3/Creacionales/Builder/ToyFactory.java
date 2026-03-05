package edu.dosw.bitacora.Semana3.Creacionales.Builder;

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

