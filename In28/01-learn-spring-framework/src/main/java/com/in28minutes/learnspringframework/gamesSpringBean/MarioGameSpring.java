package com.in28minutes.learnspringframework.gamesSpringBean;

public class MarioGameSpring implements GamingConsoleSpring{
    @Override
    public void up() {
        System.out.println("Jump");
    }

    @Override
    public void down(){
        System.out.println("Go into a hole");
    }

    @Override
    public void left(){
        System.out.println("Go back");
    }

    @Override
    public void right(){
        System.out.println("Acelerate");
    }
}
