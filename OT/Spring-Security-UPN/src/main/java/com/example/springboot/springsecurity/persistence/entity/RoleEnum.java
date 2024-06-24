package com.example.springboot.springsecurity.persistence.entity;

public enum RoleEnum {
    ADMIN("ADMIN"),
    USER("USER"),
    INVITED("INVITED"),
    DEVELOPER("DEVELoPER");

    RoleEnum(String name) {
    }
}
