package com.academico.sistemaacademico.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull(message = "O aluno é obrigatório")
    private Aluno aluno;

    @ManyToOne
    @NotNull(message = "A turma é obrigatória")
    private Turma turma;
}
