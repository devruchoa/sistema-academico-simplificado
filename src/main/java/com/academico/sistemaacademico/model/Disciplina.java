package com.academico.sistemaacademico.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

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

    public Disciplina() {
    }

    public Disciplina(Long id, String nome, String codigo, String ementa, Integer cargaHoraria) {
        this.id = id;
        this.nome = nome;
        this.codigo = codigo;
        this.ementa = ementa;
        this.cargaHoraria = cargaHoraria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", codigo='" + codigo + '\'' +
                ", ementa='" + ementa + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disciplina that = (Disciplina) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(nome, that.nome) &&
                Objects.equals(codigo, that.codigo) &&
                Objects.equals(ementa, that.ementa) &&
                Objects.equals(cargaHoraria, that.cargaHoraria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, codigo, ementa, cargaHoraria);
    }
}
