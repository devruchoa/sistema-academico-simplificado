package com.academico.sistemaacademico.controller;

import com.academico.sistemaacademico.model.Disciplina;
import com.academico.sistemaacademico.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

    @Autowired
    private DisciplinaService disciplinaService;

    @GetMapping
    public List<Disciplina> listarDisciplinas() {
        return disciplinaService.listarDisciplinas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Disciplina> buscarDisciplinaPorId(@PathVariable Long id) {
        return disciplinaService.buscarDisciplinaPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Disciplina cadastrarDisciplina(@RequestBody Disciplina disciplina) {
        return disciplinaService.cadastrarDisciplina(disciplina);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Disciplina> atualizarDisciplina(@PathVariable Long id, @RequestBody Disciplina disciplina) {
        return ResponseEntity.ok(disciplinaService.atualizarDisciplina(id, disciplina));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarDisciplina(@PathVariable Long id) {
        disciplinaService.deletarDisciplina(id);
        return ResponseEntity.noContent().build();
    }
}
