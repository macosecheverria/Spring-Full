package org.example.springcloud.msvc.usuarios.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msvc-courses", url = "${msvc.courses.url}")
public interface CourseClientRest {

    @DeleteMapping("/api/courses/remove-course-user/{id}")
    void deleteCourseUserById(@PathVariable Long id);
}
