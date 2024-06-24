package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.gamesSpringBean.GameRunnerSpring;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.in28minutes.learnspringframework.gamesSpringBean.GameSpringBeanConfiguration;
import com.in28minutes.learnspringframework.gamesSpringBean.GamingConsoleSpring;

public class App03GamingBasicSpringBeans {
    public static void main(String[] args) {

            var context = new AnnotationConfigApplicationContext(GameSpringBeanConfiguration.class);
            context.getBean(GamingConsoleSpring.class).up();
            context.getBean(GameRunnerSpring.class).run();

            context.close();


    }
}
