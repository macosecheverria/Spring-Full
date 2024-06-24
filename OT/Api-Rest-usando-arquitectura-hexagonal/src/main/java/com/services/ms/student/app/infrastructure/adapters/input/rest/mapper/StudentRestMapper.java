package com.services.ms.student.app.infrastructure.adapters.input.rest.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.services.ms.student.app.domain.models.Student;
import com.services.ms.student.app.infrastructure.adapters.input.rest.model.request.StudentCreateRequest;
import com.services.ms.student.app.infrastructure.adapters.input.rest.model.response.StudentResponse;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StudentRestMapper {

    Student toStudent(StudentCreateRequest createRequest);

    StudentResponse toStudentResponse(Student student);

    List<StudentResponse> toStudentResponseList(List<Student> studentList);

}
