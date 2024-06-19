package com.example.student.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Estudiantes {
    @Id
    private String _id;
    private String nombre;
    private String ciclo;
    private String facultad;
    private String codigoEstudiante;
    private String estado;
}
