package com.in28minutes.learnspringframework.examples.a6Xmlconfigurationcontext;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlConfigurationContextLauncherApplcation {
    public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext("contextConfiguration.xml");

        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        System.out.println(context.getBean("name"));
        System.out.println(context.getBean("age"));

        context.close();
    }
}
