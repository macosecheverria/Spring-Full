package com.services.ms.student.app.infrastructure.adapters.input.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.services.ms.student.app.application.ports.input.StudentServicePort;
import com.services.ms.student.app.infrastructure.adapters.input.rest.mapper.StudentRestMapper;
import com.services.ms.student.app.infrastructure.adapters.input.rest.model.request.StudentCreateRequest;
import com.services.ms.student.app.infrastructure.adapters.input.rest.model.response.StudentResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentRestAdapter {

    private final StudentServicePort servicePort;
    private final StudentRestMapper restMapper;

    @GetMapping("/v1/api")
    public ResponseEntity<List<StudentResponse>> findAll() {
        List<StudentResponse> studenslist = this.restMapper.toStudentResponseList(this.servicePort.findAll());

        return ResponseEntity.ok(studenslist);
    }

    @GetMapping("/v1/api/{id}")
    public ResponseEntity<StudentResponse> findById(@PathVariable Long id) {
        StudentResponse student = this.restMapper.toStudentResponse(this.servicePort.findById(id));

        return ResponseEntity.ok(student);
    }

    @PostMapping("/v1/api")
    public ResponseEntity<StudentResponse> save(@RequestBody StudentCreateRequest createRequest) {
        StudentResponse studen = this.restMapper
                .toStudentResponse(this.servicePort.save(this.restMapper.toStudent(createRequest)));

        return ResponseEntity.status(201).body(studen);
    }

    @PutMapping("/v1/api")
    public ResponseEntity<StudentResponse> update(@RequestParam Long id,
            @Valid @RequestBody StudentCreateRequest updateRequest) {
        StudentResponse studen = this.restMapper
                .toStudentResponse(this.servicePort.update(id, this.restMapper.toStudent(updateRequest)));

        return ResponseEntity.ok(studen);
    }

    @DeleteMapping("/v1/api/{id}")
    public ResponseEntity<String> remove(@PathVariable Long id) {
        this.servicePort.deleteById(id);
        return ResponseEntity.ok("Studen Removed");
    }
}
