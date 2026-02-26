package edu.dosw.bitacora.DOSW_Bitacora_DanielRodriguez.Semana3.Comportamiento.Command;

public class WalkCommand implements Command {
    private GameCharacter character;

    public WalkCommand(GameCharacter character) {
        this.character = character;
    }

    @Override
    public void execute() {
        character.walk();
    }
}
