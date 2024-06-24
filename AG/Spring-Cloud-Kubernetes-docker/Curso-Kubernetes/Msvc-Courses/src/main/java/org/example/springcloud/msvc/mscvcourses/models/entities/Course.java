package org.example.springcloud.msvc.mscvcourses.models.entities;

import jakarta.persistence.*;
import lombok.*;
import org.example.springcloud.msvc.mscvcourses.models.pojos.User;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
@Entity
@Table(name ="courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "course_id")
    private List<CourseUser> courseUsers;

    @Transient
    private List<User> users;

    public Course(){
        this.courseUsers = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void addCourseUser(CourseUser courseUser){
        this.courseUsers.add(courseUser);
    }

    public void removeCourseUser(CourseUser courseUser){
        this.courseUsers.remove(courseUser);
    }
}
