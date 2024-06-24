package com.in28minutes.learnspringframework.helloWorld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person(String name, int age, Address address) {
};

record Address(String firstLine, String city) {
};

@Configuration
public class HelloWorldconfiguration {

    @Bean
    public String name() {
        return "Marcos";
    }

    @Bean
    public int age() {
        return 25;
    }

    @Bean
    @Primary
    public Person person() {
        return new Person("Juan", 32,  new Address("Ruta Departamental", "Capiata"));

    }

    @Bean
    public Person person2MethodCall(){
        return new Person(name(), age(), address());
    }

    @Bean
    public Person person3Parameters(String name, int age,  @Qualifier("address2qualifier") Address address){
        return new Person(name, age, address);
    }

    @Bean
    @Primary
    public Address address() {
        return new Address("Los Santos", "San Andreas");
    }


     @Bean("addressNew")
     @Qualifier("address2qualifier")
    public Address address2() {
        return new Address("Costa del Valle", "Liberty City");
    }
}
