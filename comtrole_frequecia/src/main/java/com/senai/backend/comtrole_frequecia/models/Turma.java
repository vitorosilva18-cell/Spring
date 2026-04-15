package com.senai.backend.comtrole_frequecia.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "turmas")
public class Turma {

    @Column(name = "id_turma")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @JoinColumn(name = "id_aluno")
    private List<Aluno> alunos;

    public Turma() {
    }

    public Turma(Long id, String nome, List<Aluno> alunos) {
        this.id = id;
        this.nome = nome;
        this.alunos = alunos;
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

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    
    
}
