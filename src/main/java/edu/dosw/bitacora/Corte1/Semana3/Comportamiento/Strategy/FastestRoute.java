package edu.dosw.bitacora.Corte1.Semana3.Comportamiento.Strategy;

public class FastestRoute implements RouteStrategy {

    @Override
    public void calculateRoute() {
        System.out.println("Calculating fastest route");
    }
}
