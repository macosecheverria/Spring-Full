package org.example.springcloud.msvc.mscvcourses.services;

import lombok.RequiredArgsConstructor;
import org.example.springcloud.msvc.mscvcourses.clients.UsersClientRest;
import org.example.springcloud.msvc.mscvcourses.exception.CourseNotFoundException;
import org.example.springcloud.msvc.mscvcourses.models.dtos.CreateCourseDto;
import org.example.springcloud.msvc.mscvcourses.models.dtos.UpdateCourseDto;
import org.example.springcloud.msvc.mscvcourses.models.entities.Course;
import org.example.springcloud.msvc.mscvcourses.models.entities.CourseUser;
import org.example.springcloud.msvc.mscvcourses.models.pojos.User;
import org.example.springcloud.msvc.mscvcourses.repositories.CourseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService{

    private final CourseRepository courseRepository;

    private final UsersClientRest client;

    @Override
    @Transactional(readOnly = true)
    public List<Course> findAll() {
        return this.courseRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Course findById(Long id) {
        return this.courseRepository.findById(id).orElseThrow(
                () -> new CourseNotFoundException("Course withe id" + id + " not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Course> findAllById(Long id) {
        Optional<Course> courseById = this.courseRepository.findById(id);

        if(courseById.isPresent()) {
            Course course = courseById.get();

            if(!course.getCourseUsers().isEmpty()){
                List<Long> ids = course.getCourseUsers()
                        .stream()
                        .map(CourseUser::getUserId)
                        .toList();

                List<User> users = this.client.findAllById(ids);
                course.setUsers(users);
            }

            return Optional.of(course);
        }

        return Optional.empty();
    }

    @Override
    @Transactional
    public Course save(CreateCourseDto createCourseDto) {
        Course newCourse = Course.builder()
                .name(createCourseDto.getName())
                .build();

        return this.courseRepository.save(newCourse);
    }

    @Override
    @Transactional
    public Course update(Long id, UpdateCourseDto updateCourseDto) {
        Course courseUpdated = this.findById(id);

        courseUpdated.setName(updateCourseDto.getName());

        return courseUpdated;
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
     Course existId = this.findById(id);
     this.courseRepository.deleteById(existId.getId());
    }

    @Override
    @Transactional
    public void deleteCourseUserById(Long id) {
        this.courseRepository.deleteCourseUserById(id);
    }

    @Override
    @Transactional
    public Optional<User> assignUser(User user, Long courseId) {
        Optional<Course> existCourse = this.courseRepository.findById(courseId);

        if(existCourse.isPresent()) {
            User userMsvc = this.client.findById(user.getId());
            Course course = existCourse.get();

            CourseUser courseUser = CourseUser.builder()
                    .userId(userMsvc.getId())
                    .build();

            course.addCourseUser(courseUser);

            this.courseRepository.save(course);

            return Optional.of(userMsvc);

        }

        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<User> createUser(User user, Long courseId) {
        Optional<Course> existCourse =  this.courseRepository.findById(courseId);

        if(existCourse.isPresent()) {
            User userCreatedMsvc =  this.client.create(user);

            Course course = existCourse.get();
            CourseUser courseUser = CourseUser.builder()
                    .userId(userCreatedMsvc.getId())
                    .build();

            course.addCourseUser(courseUser);
            this.courseRepository.save(course);

            return Optional.of(userCreatedMsvc);
        }

        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<User> removeUser(User user, Long courseId) {

        Optional<Course> existCourse = this.courseRepository.findById(courseId);

        if(existCourse.isPresent()) {
            User userMsvc = this.client.findById(user.getId());
            Course course = existCourse.get();

            CourseUser courseUser = CourseUser.builder()
                    .userId(userMsvc.getId())
                    .build();

            course.removeCourseUser(courseUser);

            this.courseRepository.save(course);

            return Optional.of(userMsvc);

        }

        return Optional.empty();
    }
}
