package edu.dosw.bitacora.Semana3.Estructurales.Decorator;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {

        Barco barcoBase = new BarcoBase();

        Map<String, Function<Barco, Barco>> mejoras = Map.of(
                "BLINDAJE", BlindajeDecorador::new,
                "RADAR", RadarDecorador::new,
                "MISILES", MisilesDecorador::new,
                "ANTITORPEDOS", AntiTorpedosDecorador::new
        );

        List<String> configuracion = List.of(
                "BLINDAJE",
                "RADAR",
                "MISILES"
        );

        // Me toco cambiar esta parte por que como estaba antes no compilaba

        Barco barcoFinal = configuracion.stream()
                .map(mejoras::get)
                .filter(java.util.Objects::nonNull)
                .reduce(barcoBase,
                        (barco, deco) -> deco.apply(barco),
                        (a, b) -> b
                );

        System.out.println(barcoFinal.getDescripcion());
        System.out.println("Ataque: " + barcoFinal.poderAtaque());
        System.out.println("Defensa: " + barcoFinal.defensa());
    }
}