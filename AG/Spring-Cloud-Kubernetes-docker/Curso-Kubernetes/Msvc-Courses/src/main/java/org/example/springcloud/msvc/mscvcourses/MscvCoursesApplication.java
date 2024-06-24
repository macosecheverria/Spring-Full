package org.example.springcloud.msvc.mscvcourses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MscvCoursesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MscvCoursesApplication.class, args);
    }

}
