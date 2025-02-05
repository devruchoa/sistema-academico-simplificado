package com.academico.sistemaacademico.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

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

    public Matricula() {
    }

    public Matricula(Long id, Aluno aluno, Turma turma) {
        this.id = id;
        this.aluno = aluno;
        this.turma = turma;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    @Override
    public String toString() {
        return "Matricula{" +
                "id=" + id +
                ", aluno=" + aluno +
                ", turma=" + turma +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matricula matricula = (Matricula) o;
        return Objects.equals(id, matricula.id) &&
                Objects.equals(aluno, matricula.aluno) &&
                Objects.equals(turma, matricula.turma);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, aluno, turma);
    }
}
