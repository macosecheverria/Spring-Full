package com.in28minutes.springboot.learnjpaandhibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//import com.in28minutes.springboot.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
// import com.in28minutes.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.in28minutes.springboot.learnjpaandhibernate.course.springdatajpa.SpringDataJpaRepository;

@Component
public class CourseComandLineRunner implements CommandLineRunner {

    // @Autowired
    // private CourseJdbcRepository repository;

    // @Autowired
    // private CourseJpaRepository repository;

    // @Override
    // public void run(String... args) throws Exception {
    // repository.insert(new Course(1, "Learn Aws", "in28minutes"));

    // repository.insert(new Course(2, "Learn Azure", "in28minutes"));

    // repository.insert(new Course(3, "Learn Digital Ocean", "in28minutes"));

    // repository.removeById(3);

    // System.out.println(repository.findById(2));

    // }

    @Autowired
    private SpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1, "Learn AWS Spring Data Jpa", "in28minutes"));
        repository.save(new Course(2, "Learn Azure Spring Data Jpa", "in28minutes"));
        repository.save(new Course(3, "Learn DevOps Spring Data Jpa", "in28minutes"));
        repository.save(new Course(4, "Learn Remove", "in28minutes"));

        repository.deleteById(4l);

        System.out.println(repository.findById(2l));
        System.out.println("Find All of Courses: " + repository.findAll());
        System.out.println(" Find By Author: " + repository.findByAuthor("in28minutes"));
        System.out.println("Find By Author: " + repository.findByAuthor(""));
        System.out.println("Find By Name: " + repository.findByName("Learn AWS Spring Data Jpa"));
        System.out.println("Find By Name: " + repository.findByName(""));

    }

}
