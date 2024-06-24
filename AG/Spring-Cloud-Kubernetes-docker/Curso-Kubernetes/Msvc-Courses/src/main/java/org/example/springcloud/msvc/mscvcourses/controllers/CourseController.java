package org.example.springcloud.msvc.mscvcourses.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.springcloud.msvc.mscvcourses.models.dtos.CreateCourseDto;
import org.example.springcloud.msvc.mscvcourses.models.dtos.UpdateCourseDto;
import org.example.springcloud.msvc.mscvcourses.models.entities.Course;
import org.example.springcloud.msvc.mscvcourses.models.pojos.User;
import org.example.springcloud.msvc.mscvcourses.services.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<List<Course>> findAll(){
        return ResponseEntity.ok(this.courseService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> findById(@PathVariable Long id){
        Optional<Course> course = this.courseService.findAllById(id);
        return ResponseEntity.ok(course.get());
    }

    @PostMapping
    public ResponseEntity<Course> save(@Valid @RequestBody  CreateCourseDto createCourseDto){
        return ResponseEntity.status(201).body(this.courseService.save(createCourseDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> update(
            @PathVariable Long id, @Valid @RequestBody UpdateCourseDto updateCourseDto){
        return ResponseEntity.ok(this.courseService.update(id, updateCourseDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        this.courseService.deleteById(id);
        return  ResponseEntity.ok("Course deleted successfully");
    }

    @PutMapping("/assign-user/{courseId}")
    public ResponseEntity<?> assignUser(@RequestBody User user, @PathVariable Long courseId){
        Optional<User> userOptional = this.courseService.assignUser(user, courseId);

        if (userOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(userOptional.get());

        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/create-user/{courseId}")
    public ResponseEntity<?> createUser(@RequestBody User user, @PathVariable Long courseId){
        Optional<User> userOptional =  this.courseService.createUser(user, courseId);

        if(userOptional.isPresent()) {

            return ResponseEntity.status(201).body(userOptional.get());
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/remove-user/{courseId}")
    public ResponseEntity<?> removeUser(@RequestBody User user, @PathVariable Long courseId){
        Optional<User> userOptional = this.courseService.removeUser(user, courseId);

        if(userOptional.isPresent()){
            return ResponseEntity.status(200).body("User Deleted: " + userOptional.get());
        }

        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/remove-course-user/{id}")
    public ResponseEntity<?> deleteCourseUserById(@PathVariable Long id){
        this.courseService.deleteCourseUserById(id);
        return ResponseEntity.ok("User Remove of the Course");
    }
}
