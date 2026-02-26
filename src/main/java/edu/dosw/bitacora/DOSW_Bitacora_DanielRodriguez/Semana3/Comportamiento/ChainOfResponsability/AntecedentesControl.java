package edu.dosw.bitacora.DOSW_Bitacora_DanielRodriguez.Semana3.Comportamiento.ChainOfResponsability;

public class AntecedentesControl extends ControlMigratorioHandler {

    @Override
    public void procesar(IngresoRequest request) {
        if (!request.isAntecedentesLimpios()) {
            System.out.println("Antecedentes negativos");
            return;
        }
        pasarAlSiguiente(request);
    }
}

