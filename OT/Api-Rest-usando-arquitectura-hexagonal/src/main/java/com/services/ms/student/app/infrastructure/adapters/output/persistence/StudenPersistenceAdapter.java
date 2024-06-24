package com.services.ms.student.app.infrastructure.adapters.output.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.services.ms.student.app.application.ports.output.StudentPersistencePort;
import com.services.ms.student.app.domain.models.Student;
import com.services.ms.student.app.infrastructure.adapters.output.persistence.mapper.StudentPersisitenceMapper;
import com.services.ms.student.app.infrastructure.adapters.output.persistence.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class StudenPersistenceAdapter implements StudentPersistencePort{

    private final StudentRepository studenRepository;
    private final StudentPersisitenceMapper mapper;

    @Override
    public Optional<Student> findById(Long id) {
        return this.studenRepository.findById(id)
            .map(mapper::toStudent);
    }

    @Override
    public List<Student> finAll() {
      return mapper.toStudentsList(this.studenRepository.findAll());
    }

    @Override
    public Student save(Student student) {
        return mapper.toStudent(
            this.studenRepository.save(mapper.toStudentEntity(student)));
    }

    @Override
    public void deleteById(Long id) {
       this.studenRepository.deleteById(id);
    }
    
}
