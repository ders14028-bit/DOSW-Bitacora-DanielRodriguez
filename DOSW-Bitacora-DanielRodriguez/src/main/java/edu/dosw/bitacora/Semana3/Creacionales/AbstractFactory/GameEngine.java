package edu.dosw.bitacora.Semana3.Creacionales.AbstractFactory;

public class GameEngine {

    private Controller controller;
    private Game game;
    private UI ui;

    public GameEngine(ConsoleFactory factory) {
        this.controller = factory.createController();
        this.game = factory.createGame();
        this.ui = factory.createUI();
    }

    public void run() {
        controller.connect();
        game.start();
        ui.render();
    }
}
