package org.example.springcloud.msvc.mscvcourses.services;

import org.example.springcloud.msvc.mscvcourses.models.dtos.CreateCourseDto;
import org.example.springcloud.msvc.mscvcourses.models.dtos.UpdateCourseDto;
import org.example.springcloud.msvc.mscvcourses.models.entities.Course;
import org.example.springcloud.msvc.mscvcourses.models.pojos.User;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    List<Course> findAll();

    Course findById(Long id);

    Optional<Course> findAllById(Long id);
    Course save(CreateCourseDto createCourseDto);

    Course update(Long id, UpdateCourseDto updateCourseDto);

    void  deleteById(Long id);

    void deleteCourseUserById(Long id);


    Optional<User> assignUser(User user, Long courseId);

    Optional<User> createUser(User user, Long courseId);

    Optional<User> removeUser(User user, Long userId);
}
