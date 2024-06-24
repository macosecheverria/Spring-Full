package com.example.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.bean.Vehicle;
import com.example.config.ProjectConfig;

public class Example4 {
    public static void main(String[] args) {
        
        var context =  new AnnotationConfigApplicationContext(ProjectConfig.class);

        Vehicle veh = context.getBean(Vehicle.class);
        System.out.println("Vehicle name from Spring Context: " + veh.getName());

    }
}
