package edu.dosw.bitacora.Semana3.Comportamiento.Command;

public class JumpCommand implements Command {
    private GameCharacter character;

    public JumpCommand(GameCharacter character) {
        this.character = character;
    }

    @Override
    public void execute() {
        character.jump();
    }
}
