package com.academico.sistemaacademico.repository;

import com.academico.sistemaacademico.model.Aluno;
import com.academico.sistemaacademico.model.Matricula;
import com.academico.sistemaacademico.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
    boolean existsByAlunoAndTurma(Aluno aluno, Turma turma);
    List<Matricula> findByTurmaId(Long turmaId);
}
