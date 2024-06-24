package com.in28minutes.learnspringframework.examples.a2DependecyInjection;

//import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

//@Component
@Repository
@Primary
public class MongoDbDataService implements DataServices {

    @Override
    public int[] retrieveData() {
        return new int[] { 20, 30, 40, 50 };
    }
}
