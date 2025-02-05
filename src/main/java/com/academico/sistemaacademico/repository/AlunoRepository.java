package com.academico.sistemaacademico.repository;

import com.academico.sistemaacademico.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    boolean existsByCpf(String cpf);
    boolean existsByEmail(String email);
}
