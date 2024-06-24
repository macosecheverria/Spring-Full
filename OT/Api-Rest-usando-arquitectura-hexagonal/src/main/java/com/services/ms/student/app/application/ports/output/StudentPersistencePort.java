package com.services.ms.student.app.application.ports.output;

import java.util.List;
import java.util.Optional;

import com.services.ms.student.app.domain.models.Student;

public interface StudentPersistencePort {
    Optional<Student> findById(Long id);

    List<Student> finAll();

    Student save(Student student);

    void deleteById(Long id);

}
