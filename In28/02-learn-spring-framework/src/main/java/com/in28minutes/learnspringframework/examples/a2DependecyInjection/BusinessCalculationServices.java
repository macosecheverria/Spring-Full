package com.in28minutes.learnspringframework.examples.a2DependecyInjection;

import java.util.Arrays;

//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
@Service
public class BusinessCalculationServices {

    private DataServices dataServices;

    public BusinessCalculationServices(DataServices dataServices){
        super();
        this.dataServices = dataServices;
    }

    public int findMax(){
        return Arrays.stream(dataServices.retrieveData()).max().orElse(0);
    }
}
