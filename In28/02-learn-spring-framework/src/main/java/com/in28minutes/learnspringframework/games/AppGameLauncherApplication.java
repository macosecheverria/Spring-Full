package com.in28minutes.learnspringframework.games;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.in28minutes.learnspringframework.games")
public class AppGameLauncherApplication {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(AppGameLauncherApplication.class);            

        context.getBean(GamingConsole.class).up();
        context.getBean(GameRunner.class).run();

        context.close();


    }
}
