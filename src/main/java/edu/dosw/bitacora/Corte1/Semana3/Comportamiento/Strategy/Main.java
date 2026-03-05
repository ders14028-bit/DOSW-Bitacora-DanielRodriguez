package edu.dosw.bitacora.Semana3.Comportamiento.Strategy;

import java.lang.Class;

public class Main {
    public static void main(String[] args) {
        java.lang.Class app = new Class(new FastestRoute());
        app.startNavigation();

        app.setRouteStrategy(new ScenicRoute());
        app.startNavigation();

        app.setRouteStrategy(new CheapestRoute());
        app.startNavigation();
    }
}

