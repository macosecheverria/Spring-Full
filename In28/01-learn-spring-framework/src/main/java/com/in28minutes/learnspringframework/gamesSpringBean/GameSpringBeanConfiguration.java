package com.in28minutes.learnspringframework.gamesSpringBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameSpringBeanConfiguration {

    @Bean
    public GamingConsoleSpring pacmanGame(){
        var game = new PacmanGameSpring();
        return game;
    }

    @Bean
    public GameRunnerSpring gameRunnerSpring(GamingConsoleSpring game){
        var gameRunner = new GameRunnerSpring(game);
        return gameRunner;
    }


}