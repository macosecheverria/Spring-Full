package com.in28minutes.learnspringframework.games;

import org.springframework.stereotype.Component;

@Component
public class PacmanGame implements GamingConsole {

    @Override
    public void up() {
        System.out.println("UP");
    }

    @Override
    public void down() {
        System.out.println("DOWN");
    }

    @Override
    public void left() {
        System.out.println("LEFT");
    }

    @Override
    public void right() {
        System.out.println("RIGHT");
    }
    
}
