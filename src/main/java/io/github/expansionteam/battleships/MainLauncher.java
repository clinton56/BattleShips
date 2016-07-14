package io.github.expansionteam.battleships;

import io.github.expansionteam.battleships.engine.game.GameEngine;
import io.github.expansionteam.battleships.ui.ConsoleOutputOperations;

public class MainLauncher {

    public static void main(String[] args) {
        GameEngine gameEngine = new GameEngine(new ConsoleOutputOperations());
        gameEngine.launch();
    }
    
}
