package com.andres.curso.springboot.datajpa.springbootdatajpa.dtos;

public class PersonDto {
    private String name;
    private String lastName;

    public PersonDto(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "PersonDto [name=" + name + ", lastName=" + lastName + "]";
    }

    

}
