package com.in28minutes.learnspringframework.examples.a6Cdicontext;

import java.util.Arrays;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import jakarta.inject.Inject;
import jakarta.inject.Named;

//@Component
@Named
class BusinessServices {
    private DataServices dataServices;

    public DataServices getDataServices() {
        return dataServices;
    }

    //@Autowired
    @Inject
    public void setDataServices(DataServices dataServices) {
        System.out.println("Setter injection");
        this.dataServices = dataServices;
    }

}

//@Component
@Named
class DataServices {

}

@Configuration
@ComponentScan
public class CdiContextLaucherApplication {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(CdiContextLaucherApplication.class);

        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        System.out.println(context.getBean(BusinessServices.class).getDataServices());

        context.close();
    }

}
