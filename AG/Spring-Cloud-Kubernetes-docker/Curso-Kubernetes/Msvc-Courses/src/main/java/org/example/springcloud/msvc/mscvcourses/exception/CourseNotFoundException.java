package org.example.springcloud.msvc.mscvcourses.exception;


public class CourseNotFoundException extends  RuntimeException{
    public CourseNotFoundException(String message){
        super(message);
    }
}
