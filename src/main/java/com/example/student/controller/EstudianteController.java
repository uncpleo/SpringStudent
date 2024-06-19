package com.example.student.controller;

import com.example.student.model.Estudiantes;
import com.example.student.repo.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {
    @Autowired
    private EstudianteRepository estudianteRepository;

    @GetMapping("")
    List<Estudiantes> index() {
        return estudianteRepository.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    Estudiantes create(@RequestBody Estudiantes estudiantes) {
        return estudianteRepository.save(estudiantes);
    }

    @PutMapping("{id}")
    Estudiantes update(@PathVariable String id, @RequestBody Estudiantes estudiantes){
        Estudiantes estudiantesFromDB = estudianteRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);

        estudiantesFromDB.setNombre(estudiantes.getNombre());
        estudiantesFromDB.setCiclo(estudiantes.getCiclo());
        estudiantesFromDB.setFacultad(estudiantes.getFacultad());
        estudiantesFromDB.setCodigoEstudiante(estudiantes.getCodigoEstudiante());
        estudiantesFromDB.setEstado(estudiantes.getEstado());

        return estudianteRepository.save(estudiantesFromDB);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    void delete(@PathVariable String id){
        Estudiantes estudiantes = estudianteRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);

        estudianteRepository.delete(estudiantes);
    }
}
