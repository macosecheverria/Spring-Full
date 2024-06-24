package com.in28minutes.learnspringframework.examples.a2DependecyInjection;

//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
@Repository
public class MySqlDataService implements DataServices {
    
    @Override
    public int[] retrieveData() {
        return new int[] { 1, 2, 3, 4, 5 };
    }
}
