package com.services.ms.student.app.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.services.ms.student.app.application.ports.input.StudentServicePort;
import com.services.ms.student.app.application.ports.output.StudentPersistencePort;
import com.services.ms.student.app.domain.exception.StudenNotFoundException;
import com.services.ms.student.app.domain.models.Student;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService implements StudentServicePort {

    private final StudentPersistencePort studentPersistencePort;

    @Override
    public Student findById(Long id) {
        return this.studentPersistencePort.findById(id)
                .orElseThrow(StudenNotFoundException::new);
    }

    @Override
    public List<Student> findAll() {
        return this.studentPersistencePort.finAll();
    }

    @Override
    public Student save(Student student) {
        return this.studentPersistencePort.save(student);
    }

    @Override
    public Student update(Long id, Student student) {
        return this.studentPersistencePort.findById(id)
            .map(saveStuden -> {
                saveStuden.setFirtsname(student.getFirtsname());
                saveStuden.setLastname(student.getLastname());
                saveStuden.setAge(student.getAge());
                saveStuden.setAddress(student.getAddress());

                return this.studentPersistencePort.save(student);
            })
            .orElseThrow(StudenNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        Optional<Student> existStudent = this.studentPersistencePort.findById(id);

        if(!existStudent.isEmpty()){
            throw new StudenNotFoundException(); 
        }


        this.studentPersistencePort.deleteById(existStudent.get().getId());
    }

}
