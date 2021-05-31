package academy.capgemini;

import academy.capgemini.controller.ArenaController;
import academy.capgemini.model.Arena;

public class Main {

    public static void main(String[] args) {
        Arena arena = new Arena();
        ArenaController arenaController = new ArenaController(arena);
        arenaController.startGame();
    }
}
