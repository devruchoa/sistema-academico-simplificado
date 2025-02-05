package com.academico.sistemaacademico.controller;

import com.academico.sistemaacademico.model.Turma;
import com.academico.sistemaacademico.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @GetMapping
    public List<Turma> listarTurmas() {
        return turmaService.listarTurmas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turma> buscarTurmaPorId(@PathVariable Long id) {
        return turmaService.buscarTurmaPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Turma cadastrarTurma(@RequestBody Turma turma) {
        return turmaService.cadastrarTurma(turma);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Turma> atualizarTurma(@PathVariable Long id, @RequestBody Turma turma) {
        return ResponseEntity.ok(turmaService.atualizarTurma(id, turma));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTurma(@PathVariable Long id) {
        turmaService.deletarTurma(id);
        return ResponseEntity.noContent().build();
    }
}
