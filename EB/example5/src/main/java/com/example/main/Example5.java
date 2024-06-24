package com.example.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.bean.Vehicle;
import com.example.config.ProjectConfig;

public class Example5 {
    public static void main(String[] args) {
        
        var context =  new AnnotationConfigApplicationContext(ProjectConfig.class);

        Vehicle vehicle  = context.getBean(Vehicle.class);
        System.out.println("Component Vehicle name from Spring Context: " + vehicle.getName());
        vehicle.printHello();

    }
}
