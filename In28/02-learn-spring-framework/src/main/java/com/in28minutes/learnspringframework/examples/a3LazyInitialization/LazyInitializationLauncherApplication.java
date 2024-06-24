package com.in28minutes.learnspringframework.examples.a3LazyInitialization;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class ClassA {

}

@Component
@Lazy
class ClassB {

    private ClassA classA;

    public ClassB(ClassA classA) {
        super();
        this.classA = classA;
    }

    public void doSomething() {
        System.out.println("Do Something");
    }

    public ClassA getClassA() {
        return classA;
    }
}

@Configuration
@ComponentScan
public class LazyInitializationLauncherApplication {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(LazyInitializationLauncherApplication.class);

        System.out.println("Initialization of context is completed");

        context.getBean(ClassB.class).doSomething();

        context.close();

    }
}
