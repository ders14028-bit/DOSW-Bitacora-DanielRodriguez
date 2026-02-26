package edu.dosw.bitacora.DOSW_Bitacora_DanielRodriguez.Semana3.Comportamiento.ChainOfResponsability;

public class AprobacionFinalControl extends ControlMigratorioHandler {

    @Override
    public void procesar(IngresoRequest request) {
        request.setAprobado(true);
        System.out.println("Ingreso aprobado");
    }
}
