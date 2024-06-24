package com.example.main;

import java.util.Random;
import java.util.function.Supplier;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.bean.Vehicle;
import com.example.config.ProjectConfig;

public class Example7 {
    public static void main(String[] args) {
        
        var context =  new AnnotationConfigApplicationContext(ProjectConfig.class);

        Vehicle volkswagen = new Vehicle();
        volkswagen.setName("Volkswagen");
        Supplier<Vehicle> volkswagenSupplier = () -> volkswagen;

        Supplier<Vehicle> audiSupplier = () -> {
            Vehicle audi = new Vehicle();
            audi.setName("audi");
            return audi;
        };

        Random random = new Random();
        int randomNumber  = random.nextInt(10);
        System.out.println("randomNumber - " + randomNumber);

        if(randomNumber%2==0){
            context.registerBean("volkswagen", Vehicle.class, volkswagenSupplier);
        }else{
            context.registerBean("audi", Vehicle.class, audiSupplier);
        }

        Vehicle volkswagenVehicle =  null;
        Vehicle audiVehicle = null;

        try {
            volkswagenVehicle = context.getBean("volkswagen", Vehicle.class);
        } catch (NoSuchBeanDefinitionException e) {
            System.out.println("Error while creating Volswagen Vehicle");
        }

        try {
            audiVehicle = context.getBean("audi", Vehicle.class);
        } catch (NoSuchBeanDefinitionException e) {
            System.out.println("Error while creating Audi Vehicle ");
        }


        if(null != volkswagenVehicle){
            System.out.println("Programming Vehicle name form Spring context is: " +  volkswagenVehicle.getName());
        }

        if (null != audiVehicle) {
             System.out.println("Programming Vehicle name from Spring context is: " +  audiVehicle.getName());
        }

    }
}
