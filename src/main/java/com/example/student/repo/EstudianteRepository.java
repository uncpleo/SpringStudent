package com.example.student.repo;

import com.example.student.model.Estudiantes;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EstudianteRepository extends MongoRepository<Estudiantes, String> {
}
