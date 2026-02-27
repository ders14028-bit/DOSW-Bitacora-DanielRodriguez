package edu.dosw.bitacora.Semana3.Comportamiento.ChainOfResponsability;

public interface ControlMigratorio {
    void setSiguiente(ControlMigratorio siguiente);
    void procesar(IngresoRequest request);
}