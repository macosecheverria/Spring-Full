package com.andres.curso.springboot.app.aop.springbootaop.services;

import org.springframework.stereotype.Service;

@Service("greeting")
public class GreetingServiceImp implements GreetingService {

    @Override
    public String sayHello(String person, String phrase) {
        String greeting = phrase + " " + person;
        System.out.println(greeting);

        return greeting;
    }

    @Override
    public String sayHelloError(String persona, String phrase) {
        throw new RuntimeException("Algun Error");
    }

}
