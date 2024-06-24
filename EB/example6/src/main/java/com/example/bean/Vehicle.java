package com.example.bean;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class Vehicle {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @PostConstruct
    public void initalize() {
        this.name = "Honda";
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroy vehicle bean");
    }

    public void printHello() {
        System.out.println("Priting Hello Component Vehicle Bean");
    }

}
