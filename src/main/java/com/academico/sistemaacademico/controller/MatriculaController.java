package com.academico.sistemaacademico.controller;

import com.academico.sistemaacademico.model.Matricula;
import com.academico.sistemaacademico.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaService matriculaService;

    @GetMapping
    public List<Matricula> listarMatriculas() {
        return matriculaService.listarMatriculas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Matricula> buscarMatriculaPorId(@PathVariable Long id) {
        return matriculaService.buscarMatriculaPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Matricula matricularAluno(@RequestBody Matricula matricula) {
        return matriculaService.matricularAluno(matricula);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelarMatricula(@PathVariable Long id) {
        matriculaService.cancelarMatricula(id);
        return ResponseEntity.noContent().build();
    }
}
