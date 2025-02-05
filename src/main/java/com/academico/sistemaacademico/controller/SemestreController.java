package com.academico.sistemaacademico.controller;

import com.academico.sistemaacademico.model.Semestre;
import com.academico.sistemaacademico.service.SemestreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/semestres")
public class SemestreController {

    @Autowired
    private SemestreService semestreService;

    @GetMapping
    public List<Semestre> listarSemestres() {
        return semestreService.listarSemestres();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Semestre> buscarSemestrePorId(@PathVariable Long id) {
        return semestreService.buscarSemestrePorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Semestre cadastrarSemestre(@RequestBody Semestre semestre) {
        return semestreService.cadastrarSemestre(semestre);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Semestre> atualizarSemestre(@PathVariable Long id, @RequestBody Semestre semestre) {
        return ResponseEntity.ok(semestreService.atualizarSemestre(id, semestre));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarSemestre(@PathVariable Long id) {
        semestreService.deletarSemestre(id);
        return ResponseEntity.noContent().build();
    }
}
