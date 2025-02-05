package com.academico.sistemaacademico.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome da disciplina é obrigatório")
    private String nome;

    @NotBlank(message = "O código da disciplina é obrigatório")
    @Column(unique = true)
    private String codigo;

    @NotBlank(message = "A ementa é obrigatória")
    private String ementa;

    @NotNull(message = "A carga horária é obrigatória")
    private Integer cargaHoraria;
}
