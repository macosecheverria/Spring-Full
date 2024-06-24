package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationServices {
    
    public boolean authenticate(String username, String password){
        boolean isValidUsername  = username.equalsIgnoreCase("marcos");

        boolean isValidPassword = password.equalsIgnoreCase("soydjdark12");


        return isValidUsername && isValidPassword;
    }
}
