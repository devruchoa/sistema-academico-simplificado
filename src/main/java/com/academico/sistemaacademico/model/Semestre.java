package com.academico.sistemaacademico.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Semestre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O ano é obrigatório")
    private Integer ano;

    @NotNull(message = "O semestre é obrigatório (1 ou 2)")
    private Integer semestre;

    @NotNull(message = "A data de início é obrigatória")
    private LocalDate dataInicio;

    @NotNull(message = "A data de término é obrigatória")
    private LocalDate dataTermino;

    public Semestre() {
    }

    public Semestre(Long id, Integer ano, Integer semestre, LocalDate dataInicio, LocalDate dataTermino) {
        this.id = id;
        this.ano = ano;
        this.semestre = semestre;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
    }

    @Override
    public String toString() {
        return "Semestre{" +
                "id=" + id +
                ", ano=" + ano +
                ", semestre=" + semestre +
                ", dataInicio=" + dataInicio +
                ", dataTermino=" + dataTermino +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Semestre semestre1 = (Semestre) o;
        return Objects.equals(id, semestre1.id) &&
                Objects.equals(ano, semestre1.ano) &&
                Objects.equals(semestre, semestre1.semestre) &&
                Objects.equals(dataInicio, semestre1.dataInicio) &&
                Objects.equals(dataTermino, semestre1.dataTermino);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ano, semestre, dataInicio, dataTermino);
    }
}
