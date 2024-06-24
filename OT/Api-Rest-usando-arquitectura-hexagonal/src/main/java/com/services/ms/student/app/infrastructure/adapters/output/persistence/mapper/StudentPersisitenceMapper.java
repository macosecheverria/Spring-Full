package com.services.ms.student.app.infrastructure.adapters.output.persistence.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.services.ms.student.app.domain.models.Student;
import com.services.ms.student.app.infrastructure.adapters.output.persistence.entity.StudentEntity;

@Mapper(componentModel = "spring")
public interface StudentPersisitenceMapper {

    StudentEntity toStudentEntity(Student student);

    Student toStudent(StudentEntity entity);

    List<Student> toStudentsList(List<StudentEntity> entitiesList);
    
}
