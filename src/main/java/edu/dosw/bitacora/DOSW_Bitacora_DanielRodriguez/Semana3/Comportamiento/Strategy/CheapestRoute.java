package edu.dosw.bitacora.DOSW_Bitacora_DanielRodriguez.Semana3.Comportamiento.Strategy;

public class CheapestRoute implements RouteStrategy {
    @Override
    public void calculateRoute() {
        System.out.println("Calculating cheapest route");
    }
}