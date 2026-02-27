package edu.dosw.bitacora.Semana3.Creacionales.Builder;

public class ClassicDollBuilder implements ToyDollBuilder {

    private ToyDoll doll;

    public ClassicDollBuilder() {
        doll = new ToyDoll();
    }

    @Override
    public void buildHead() {
        doll.setHead("Cabeza clásica");
    }

    @Override
    public void buildBody() {
        doll.setBody("Cuerpo tradicional");
    }

    @Override
    public void buildArms() {
        doll.setArms("Brazos simples");
    }

    @Override
    public void buildLegs() {
        doll.setLegs("Piernas simples");
    }

    @Override
    public void addAccessories() {
        doll.setHasAccessories(false);
    }

    @Override
    public ToyDoll getResult() {
        return doll;
    }
}

