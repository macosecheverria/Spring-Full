package com.example.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.bean.Vehicle;
import com.example.config.ProjectConfig;

public class Example3 {
    public static void main(String[] args) {
        
        var context =  new AnnotationConfigApplicationContext(ProjectConfig.class);

        Vehicle veh1 = context.getBean("audiVehicle",Vehicle.class);
        System.out.println("Vehicle name from Spring Context: " + veh1.getName());

        Vehicle veh2 = context.getBean("hondaVehicle", Vehicle.class);
        System.out.println("Vehicle name from Spring Context:  " + veh2.getName());

         Vehicle veh3 = context.getBean("ferrariVehicle", Vehicle.class);
        System.out.println("Vehicle name from Spring Context: " + veh3.getName());

    }
}
