package edu.dosw.bitacora.Semana3.Creacionales.Builder;

public interface ToyDollBuilder {

    void buildHead();
    void buildBody();
    void buildArms();
    void buildLegs();
    void addAccessories();

    ToyDoll getResult();
}
