package com.in28minutes.learnspringframework.examples.a1CableadoAutomatico;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class YourBusinessClass {
    // Hay tres formas de hacer inyeccion de dependecias por setters por constructor y por campo
    // La forma  recomendada que el equipo de spring recomienda es por inyeccion por contructor por que esta lo hace de forma automatica sin usar el @Autowired

    Dependency1 dependency1;
    Dependency2 dependency2;

    @Autowired
    public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2){
        super();
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }

    // @Autowired
    // Dependency1 dependency1;

    // @Autowired
    // Dependency2 dependency2;

    // @Autowired
    // public void setDependency1(Dependency1 dependency1) {
    //     this.dependency1 = dependency1;
    // }

    // @Autowired
    // public void setDependency2(Dependency2 dependency2) {
    //     this.dependency2 = dependency2;
    // }

    public String toString() {
        return "Using " + dependency1 + " and " + dependency2;
    }
}

@Component
class Dependency1 {

}

@Component
class Dependency2 {

}

@Configuration
@ComponentScan
public class DepInjectionLaucherApplication {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(DepInjectionLaucherApplication.class);

        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        System.out.println(context.getBean(YourBusinessClass.class));

        context.close();

    }

}
