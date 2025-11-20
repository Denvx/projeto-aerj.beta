package com.example.projeto_aerj.beta.models;

import com.example.projeto_aerj.beta.enums.UsuarioStatusEnum;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String matricula;
    private String curso;
    private String istituicao;  // <- coerente com StudentEntitie

    @Enumerated(EnumType.STRING)
    private UsuarioStatusEnum usuarioStatusEnum;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;

    public Student() {
    }

    public Student(String matricula, String curso, String istituicao, UsuarioStatusEnum usuarioStatusEnum, Date dataCriacao, Date dataAtualizacao) {
        this.matricula = matricula;
        this.curso = curso;
        this.istituicao = istituicao;
        this.usuarioStatusEnum = usuarioStatusEnum;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }

    public String getCurso() { return curso; }
    public void setCurso(String curso) { this.curso = curso; }

    public String getIstituicao() { return istituicao; }
    public void setIstituicao(String istituicao) { this.istituicao = istituicao; }

    public UsuarioStatusEnum getUsuarioStatusEnum() { return usuarioStatusEnum; }
    public void setUsuarioStatusEnum(UsuarioStatusEnum usuarioStatusEnum) { this.usuarioStatusEnum = usuarioStatusEnum; }

    public Date getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(Date dataCriacao) { this.dataCriacao = dataCriacao; }

    public Date getDataAtualizacao() { return dataAtualizacao; }
    public void setDataAtualizacao(Date dataAtualizacao) { this.dataAtualizacao = dataAtualizacao; }
}
