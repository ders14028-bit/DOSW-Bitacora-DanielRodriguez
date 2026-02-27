package edu.dosw.bitacora.Semana3.Comportamiento.Strategy;

public class CheapestRoute implements RouteStrategy {
    @Override
    public void calculateRoute() {
        System.out.println("Calculating cheapest route");
    }
}