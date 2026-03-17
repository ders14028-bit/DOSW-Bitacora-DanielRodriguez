package edu.dosw.bitacora.Corte1.Semana3.Comportamiento.Strategy;

public class Class {

    private RouteStrategy routeStrategy;

    public Class(RouteStrategy routeStrategy) {
        this.routeStrategy = routeStrategy;
    }

    public void setRouteStrategy(RouteStrategy routeStrategy) {
        this.routeStrategy = routeStrategy;
    }

    public void startNavigation() {
        routeStrategy.calculateRoute();
    }
}

