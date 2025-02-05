package com.academico.sistemaacademico.repository;

import com.academico.sistemaacademico.model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
    boolean existsByCodigo(String codigo);
}
