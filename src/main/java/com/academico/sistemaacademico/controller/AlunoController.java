package com.academico.sistemaacademico.controller;

import com.academico.sistemaacademico.model.Aluno;
import com.academico.sistemaacademico.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List<Aluno> listarAlunos() {
        return alunoService.listarAlunos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarAlunoPorId(@PathVariable Long id) {
        return alunoService.buscarAlunoPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Aluno cadastrarAluno(@RequestBody Aluno aluno) {
        return alunoService.cadastrarAluno(aluno);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> atualizarAluno(@PathVariable Long id, @RequestBody Aluno alunoAtualizado) {
        return ResponseEntity.ok(alunoService.atualizarAluno(id, alunoAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAluno(@PathVariable Long id) {
        alunoService.deletarAluno(id);
        return ResponseEntity.noContent().build();
    }
}
