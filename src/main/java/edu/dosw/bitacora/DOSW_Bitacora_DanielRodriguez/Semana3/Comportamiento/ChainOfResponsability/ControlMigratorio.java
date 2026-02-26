package edu.dosw.bitacora.DOSW_Bitacora_DanielRodriguez.Semana3.Comportamiento.ChainOfResponsability;

public interface ControlMigratorio {
    void setSiguiente(ControlMigratorio siguiente);
    void procesar(IngresoRequest request);
}