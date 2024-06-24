package com.in28minutes.learnspringframework.helloWorld;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(HelloWorldconfiguration.class);

        //Algunas formas de Obtener los Beans
        System.out.println(context.getBean("name"));
        System.out.println(context.getBean("age"));
        System.out.println(context.getBean("person"));
        System.out.println(context.getBean("person2MethodCall"));
        System.out.println(context.getBean("person3Parameters"));
        System.out.println(context.getBean("address"));
        System.out.println(context.getBean("addressNew"));
        System.out.println(context.getBean(Address.class));

        //Obtener todos los Beans
        Arrays.stream(context.getBeanDefinitionNames()).forEach(el -> System.out.println(el));

        

        context.close();
    }
}
