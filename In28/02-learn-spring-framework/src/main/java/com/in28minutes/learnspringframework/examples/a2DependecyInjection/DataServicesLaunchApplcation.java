

package com.in28minutes.learnspringframework.examples.a2DependecyInjection;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class DataServicesLaunchApplcation {
    public static void main(String[] args) {
        
        var context = new AnnotationConfigApplicationContext(DataServicesLaunchApplcation.class);

        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        System.out.println(context.getBean(BusinessCalculationServices.class).findMax());

        context.close();

    }
}
