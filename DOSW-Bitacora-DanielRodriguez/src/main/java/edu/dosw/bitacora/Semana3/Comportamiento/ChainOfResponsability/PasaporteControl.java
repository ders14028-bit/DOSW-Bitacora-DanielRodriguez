package edu.dosw.bitacora.Semana3.Comportamiento.ChainOfResponsability;

public class PasaporteControl extends ControlMigratorioHandler {

    @Override
    public void procesar(IngresoRequest request) {
        if (!request.isPasaporteValido()) {
            System.out.println("Pasaporte inválido");
            return;
        }
        pasarAlSiguiente(request);
    }
}
