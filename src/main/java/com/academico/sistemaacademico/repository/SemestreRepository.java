package com.academico.sistemaacademico.repository;

import com.academico.sistemaacademico.model.Semestre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemestreRepository extends JpaRepository<Semestre, Long> {
}
