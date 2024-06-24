package com.in28minutes.learnspringframework.helloWorld;

import java.io.Serializable;

class Pojo {
    private String text;
    private int number;
    
    @Override
    public String toString() {
        return text + " : " + number ;
    }
    
}

class JavaBean implements Serializable {
    private String text;
    private int number;

    public JavaBean(){}

    public String getText(){
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getNumber(){
        return this.number;
    }

    public void setNumber(int number){
        this.number = number;
    }
}


public class SpringBeanVsJavaBean {
    public static void main(String[] args) {
        var pojo =  new Pojo();
        System.out.println(pojo);


    }
}
