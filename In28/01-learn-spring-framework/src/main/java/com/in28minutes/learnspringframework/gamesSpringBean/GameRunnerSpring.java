package com.in28minutes.learnspringframework.gamesSpringBean;

public class GameRunnerSpring {

         GamingConsoleSpring game;

        public GameRunnerSpring(GamingConsoleSpring game){
            this.game = game;
        }

        public void run(){
            System.out.println("Running game: " + game);
            game.up();
            game.down();
            game.left();
            game.right();
        }
}
