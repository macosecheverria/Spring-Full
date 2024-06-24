package com.services.ms.student.app;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.services.ms.student.app.infrastructure.adapters.output.persistence.entity.StudentEntity;
import com.services.ms.student.app.infrastructure.adapters.output.persistence.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class StudenServiceApplication implements CommandLineRunner {

	private final StudentRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(StudenServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<StudentEntity>  studenList =  List.of(
			new StudentEntity(null, "Juan", "Echeverria", 32, "Lopez Godoy"),
			new StudentEntity(null, "Marcos", "Echeverria", 25, "Los Lagos"),
			new StudentEntity(null, "Maria", "Echeverria", 28, "Yataity"),
			new StudentEntity(null, "Juana","Caceres", 60, "Concepcion")
		);

		this.repository.saveAll( studenList);
	}

}
