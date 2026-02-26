package edu.dosw.bitacora.DOSW_Bitacora_DanielRodriguez.Semana2.patrones.Eercicio2;

import java.time.LocalDate;

public class ImpresoraDetallada {

    public void imprimirDetalle(String texto, String autor, LocalDate fecha) {
        System.out.println("Mensaje: " + texto);
        System.out.println("Autor: " + autor);
        System.out.println("Fecha: " + fecha);
    }
}

