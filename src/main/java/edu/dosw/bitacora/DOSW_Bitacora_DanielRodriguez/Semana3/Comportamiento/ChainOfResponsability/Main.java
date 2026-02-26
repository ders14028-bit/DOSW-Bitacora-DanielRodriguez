package edu.dosw.bitacora.DOSW_Bitacora_DanielRodriguez.Semana3.Comportamiento.ChainOfResponsability;

public class Main {

    public static void main(String[] args) {

        ControlMigratorio pasaporte = new PasaporteControl();
        ControlMigratorio antecedentes = new AntecedentesControl();
        ControlMigratorio motivo = new MotivoViajeControl();
        ControlMigratorio aprobacion = new AprobacionFinalControl();

        pasaporte.setSiguiente(antecedentes);
        antecedentes.setSiguiente(motivo);
        motivo.setSiguiente(aprobacion);

        IngresoRequest request =
                new IngresoRequest(true, true, false);

        pasaporte.procesar(request);

    }
}