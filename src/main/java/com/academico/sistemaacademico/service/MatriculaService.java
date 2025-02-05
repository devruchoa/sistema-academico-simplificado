package com.academico.sistemaacademico.service;

import com.academico.sistemaacademico.model.Matricula;
import com.academico.sistemaacademico.repository.MatriculaRepository;
import com.academico.sistemaacademico.service.AlunoService;
import com.academico.sistemaacademico.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private TurmaService turmaService;

    public List<Matricula> listarMatriculas() {
        return matriculaRepository.findAll();
    }

    public List<Matricula> listarMatriculasPorTurma(Long turmaId) {
        return matriculaRepository.findByTurmaId(turmaId);
    }

    public Optional<Matricula> buscarMatriculaPorId(Long id) {
        return matriculaRepository.findById(id);
    }

    public Matricula matricularAluno(Matricula matricula) {
        if (!alunoService.buscarAlunoPorId(matricula.getAluno().getId()).isPresent()) {
            throw new RuntimeException("Aluno não encontrado!");
        }

        if (!turmaService.buscarTurmaPorId(matricula.getTurma().getId()).isPresent()) {
            throw new RuntimeException("Turma não encontrada!");
        }

        if (matriculaRepository.existsByAlunoAndTurma(matricula.getAluno(), matricula.getTurma())) {
            throw new RuntimeException("Aluno já matriculado nesta turma!");
        }

        return matriculaRepository.save(matricula);
    }

    public void cancelarMatricula(Long id) {
        matriculaRepository.deleteById(id);
    }
}
