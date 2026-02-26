package edu.dosw.bitacora.DOSW_Bitacora_DanielRodriguez.Semana3.Creacionales.Builder;

public class ActionDollBuilder implements ToyDollBuilder {

    private ToyDoll doll;

    public ActionDollBuilder() {
        doll = new ToyDoll();
    }

    @Override
    public void buildHead() {
        doll.setHead("Cabeza con casco");
    }

    @Override
    public void buildBody() {
        doll.setBody("Cuerpo atlético");
    }

    @Override
    public void buildArms() {
        doll.setArms("Brazos musculosos");
    }

    @Override
    public void buildLegs() {
        doll.setLegs("Piernas fuertes");
    }

    @Override
    public void addAccessories() {
        doll.setHasAccessories(true);
    }

    @Override
    public ToyDoll getResult() {
        return doll;
    }
}

