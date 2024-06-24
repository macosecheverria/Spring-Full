package com.in28minutes.springboot.learnspringboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {


    @RequestMapping("/courses")
    public List<Course> retrieveAllCourses(){
        return Arrays.asList(
            new Course(1l, "Learn Aws", "in28minutes"),
            new Course(2l, "Learn DevOps", "in28minutes"),
            new Course(3l, "Learn Azure","in28miutes"),
            new Course(4l, "Learn GCP", "in28minutes")
        );
    }
}
