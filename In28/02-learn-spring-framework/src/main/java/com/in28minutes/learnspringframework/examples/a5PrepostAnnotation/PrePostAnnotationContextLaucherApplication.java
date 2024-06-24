package com.in28minutes.learnspringframework.examples.a5PrepostAnnotation;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
class SomeClass {
    private SomeDependecy someDependecy;

    public SomeClass(SomeDependecy someDependecy){
        this.someDependecy = someDependecy;
        System.out.println("All dependecies are ready");
    }

    @PostConstruct
    public void initialize(){
        someDependecy.getReady();
    }

    @PreDestroy
    public void cleanUp(){
        System.out.println("CleanUp");
    }

}

@Component
class SomeDependecy {
    public void getReady(){
        System.out.println("Some logic using SomeDependecy");
    }
}


@Configuration
@ComponentScan
public class PrePostAnnotationContextLaucherApplication {
    public static void main(String[] args) {
        
        var context = new AnnotationConfigApplicationContext(PrePostAnnotationContextLaucherApplication.class);


        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);


        context.close();


    }    
}
