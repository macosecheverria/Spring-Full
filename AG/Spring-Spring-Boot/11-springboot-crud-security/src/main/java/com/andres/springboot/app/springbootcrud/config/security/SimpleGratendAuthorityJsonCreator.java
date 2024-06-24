package com.andres.springboot.app.springbootcrud.config.security;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class SimpleGratendAuthorityJsonCreator {

    @JsonCreator
    public SimpleGratendAuthorityJsonCreator(@JsonProperty("authority") String role){
     
    }
}
