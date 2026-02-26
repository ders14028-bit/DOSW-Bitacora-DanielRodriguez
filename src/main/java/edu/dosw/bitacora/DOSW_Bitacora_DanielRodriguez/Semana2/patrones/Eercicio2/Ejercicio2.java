package edu.dosw.bitacora.DOSW_Bitacora_DanielRodriguez.Semana2.patrones.Eercicio2;

import java.time.LocalDate;

public class Ejercicio2 {

    public static void main(String[] args) {

        Mensaje mensaje = new Mensaje( "Bitacora DOSW", "Daniel", LocalDate.now() );

        //impresora simple

        Impresora impresora1 = new ImpresoraSimpleAdapter(new ImpresoraSimple());

        impresora1.imprimir(mensaje);

        System.out.println("-------------------");

        //impresora detallada

        Impresora impresora2 = new ImpresoraDetalladaAdapter(new ImpresoraDetallada());

        impresora2.imprimir(mensaje);
    }
}


