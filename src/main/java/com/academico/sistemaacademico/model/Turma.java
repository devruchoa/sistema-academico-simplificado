package com.academico.sistemaacademico.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O horário é obrigatório")
    private String horario;

    @NotBlank(message = "O nome do professor é obrigatório")
    private String professor;

    @ManyToOne
    @NotNull(message = "A disciplina é obrigatória")
    private Disciplina disciplina;

    @ManyToOne
    @NotNull(message = "O semestre é obrigatório")
    private Semestre semestre;
}
