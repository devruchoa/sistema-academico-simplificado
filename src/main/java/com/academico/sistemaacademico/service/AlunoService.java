package com.academico.sistemaacademico.service;

import com.academico.sistemaacademico.model.Aluno;
import com.academico.sistemaacademico.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> listarAlunos() {
        return alunoRepository.findAll();
    }

    public Optional<Aluno> buscarAlunoPorId(Long id) {
        return alunoRepository.findById(id);
    }

    public Aluno cadastrarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Aluno atualizarAluno(Long id, Aluno alunoAtualizado) {
        return alunoRepository.findById(id)
                .map(aluno -> {
                    aluno.setNomeCompleto(alunoAtualizado.getNomeCompleto());
                    aluno.setDataNascimento(alunoAtualizado.getDataNascimento());
                    aluno.setCpf(alunoAtualizado.getCpf());
                    aluno.setEmail(alunoAtualizado.getEmail());
                    return alunoRepository.save(aluno);
                })
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
    }

    public void deletarAluno(Long id) {
        alunoRepository.deleteById(id);
    }
}
