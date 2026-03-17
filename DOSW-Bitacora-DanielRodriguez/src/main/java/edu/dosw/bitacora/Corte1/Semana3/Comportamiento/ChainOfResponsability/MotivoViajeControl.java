package edu.dosw.bitacora.Semana3.Comportamiento.ChainOfResponsability;

public class MotivoViajeControl extends ControlMigratorioHandler {

    @Override
    public void procesar(IngresoRequest request) {
        if (!request.isMotivoValido()) {
            System.out.println("Motivo de viaje inválido");
            return;
        }
        pasarAlSiguiente(request);
    }
}
