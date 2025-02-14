package com.in28minutes.springboot.learnspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConfigurationController {
    
    @Autowired
    private CurrencyServicesConfiguration configuration;


    @RequestMapping("/currency")
    public CurrencyServicesConfiguration currencyConfiguration(){
        return configuration;
    }

}
