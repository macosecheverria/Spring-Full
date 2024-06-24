package com.in28minutes.learnspringframework.games;

public class GameRunner {
        //MarioGame game;

        // public GameRunner(MarioGame game){
        //     this.game = game;
        // }

        // SuperContraGame game;

        // public GameRunner(SuperContraGame game){
        //     this.game = game;
        // }

         GamingConsole game;

        public GameRunner(GamingConsole game){
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
