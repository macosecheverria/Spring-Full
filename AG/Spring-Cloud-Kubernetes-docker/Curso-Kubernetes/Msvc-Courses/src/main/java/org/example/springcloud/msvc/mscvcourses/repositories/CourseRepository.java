package org.example.springcloud.msvc.mscvcourses.repositories;

import org.example.springcloud.msvc.mscvcourses.models.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CourseRepository extends JpaRepository<Course, Long> {

    @Modifying
    @Query("delete from CourseUser cu where  cu.userId=?1")
    void deleteCourseUserById(Long id);

}
