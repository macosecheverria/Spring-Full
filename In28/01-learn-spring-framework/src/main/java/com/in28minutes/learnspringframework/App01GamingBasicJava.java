package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.games.GameRunner;
import com.in28minutes.learnspringframework.games.MarioGame;
import com.in28minutes.learnspringframework.games.PacmanGame;
import com.in28minutes.learnspringframework.games.SuperContraGame;

public class App01GamingBasicJava {
    public static void main(String[] args) {
        var marioGame = new MarioGame();
        var gameRunnerMario = new GameRunner(marioGame);
        gameRunnerMario.run();

        var superContraGame = new SuperContraGame();
        var gameRunnerContra = new GameRunner(superContraGame);
        gameRunnerContra.run();

        var packmanGame = new PacmanGame();
        var gameRunnerPackman = new GameRunner(packmanGame);
        gameRunnerPackman.run();
    }
}
