package com.academico.sistemaacademico.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

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

    public Turma() {
    }

    public Turma(Long id, String horario, String professor, Disciplina disciplina, Semestre semestre) {
        this.id = id;
        this.horario = horario;
        this.professor = professor;
        this.disciplina = disciplina;
        this.semestre = semestre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Semestre getSemestre() {
        return semestre;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }

    @Override
    public String toString() {
        return "Turma{" +
                "id=" + id +
                ", horario='" + horario + '\'' +
                ", professor='" + professor + '\'' +
                ", disciplina=" + disciplina +
                ", semestre=" + semestre +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Turma turma = (Turma) o;
        return Objects.equals(id, turma.id) &&
                Objects.equals(horario, turma.horario) &&
                Objects.equals(professor, turma.professor) &&
                Objects.equals(disciplina, turma.disciplina) &&
                Objects.equals(semestre, turma.semestre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, horario, professor, disciplina, semestre);
    }
}
