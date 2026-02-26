package edu.dosw.bitacora.DOSW_Bitacora_DanielRodriguez.Semana3.Creacionales.AbstractFactory;

public interface ConsoleFactory {

    Controller createController();
    Game createGame();
    UI createUI();
}

