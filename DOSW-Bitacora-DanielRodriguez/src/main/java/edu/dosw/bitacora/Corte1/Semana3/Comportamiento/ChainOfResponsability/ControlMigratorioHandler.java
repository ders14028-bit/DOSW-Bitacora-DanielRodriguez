package edu.dosw.bitacora.Semana3.Comportamiento.ChainOfResponsability;

public abstract class ControlMigratorioHandler implements ControlMigratorio {

    protected ControlMigratorio siguiente;

    @Override
    public void setSiguiente(ControlMigratorio siguiente) {
        this.siguiente = siguiente;
    }

    protected void pasarAlSiguiente(IngresoRequest request) {
        if (siguiente != null) {
            siguiente.procesar(request);
        }
    }
}
