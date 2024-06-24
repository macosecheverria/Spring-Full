package com.example.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.bean.Vehicle;
import com.example.config.ProjectConfig;

public class Example2 {
    public static void main(String[] args) {
        
        var context =  new AnnotationConfigApplicationContext(ProjectConfig.class);

        Vehicle veh1 = context.getBean("vehicle1",Vehicle.class);
        System.out.println("Vehicle1 name is: " + veh1.getName());

        Vehicle veh2 = context.getBean("vehicle2", Vehicle.class);
        System.out.println("Vehicle2 name is: " + veh2.getName());

         Vehicle veh3 = context.getBean("vehicle3", Vehicle.class);
        System.out.println("Vehicle3 name is: " + veh3.getName());

    }
}
