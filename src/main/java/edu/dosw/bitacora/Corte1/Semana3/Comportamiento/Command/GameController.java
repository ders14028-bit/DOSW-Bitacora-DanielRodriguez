package edu.dosw.bitacora.Semana3.Comportamiento.Command;


public class GameController {
    public void pressButton(Command command) {
        command.execute();
    }
}
