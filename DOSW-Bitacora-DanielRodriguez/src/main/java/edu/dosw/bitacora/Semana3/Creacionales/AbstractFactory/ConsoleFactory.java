package edu.dosw.bitacora.Semana3.Creacionales.AbstractFactory;

public interface ConsoleFactory {

    Controller createController();
    Game createGame();
    UI createUI();
}

