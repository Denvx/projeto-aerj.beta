package com.example.projeto_aerj.beta.entities.person;

import com.example.projeto_aerj.beta.enums.UsuarioRoleEnum;
import com.example.projeto_aerj.beta.enums.UsuarioSexoEnum;
import com.example.projeto_aerj.beta.enums.UsuarioStatusEnum;
import com.example.projeto_aerj.beta.models.Student;
import com.example.projeto_aerj.beta.valueObjects.CPFValue;
import com.example.projeto_aerj.beta.valueObjects.EmailValue;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class StudentEntitie extends UserEntitie {

    private String matricula;
    private String curso;
    private String istituicao;
    private UsuarioStatusEnum usuarioStatusEnum;

    // AQUI ESTÁ A CORREÇÃO
    private int userId;

    public StudentEntitie() {}

    public StudentEntitie(
            int id,
            String name,

            @JsonProperty("cpfValue")
            CPFValue cpfValue,
            Date dataNascimento,

            @JsonProperty("emailValue")
            EmailValue emailValue,
            UsuarioSexoEnum usuarioSexoEnum,
            String senhaHash,
            UsuarioRoleEnum roleEnum,
            Date dataCriacao,
            Date dataAtualizacao,
            String matricula,
            String curso,
            String istituicao,
            UsuarioStatusEnum usuarioStatusEnum,
            int userId
    ) {
        super(id, name, cpfValue, dataNascimento, emailValue, usuarioSexoEnum, senhaHash, roleEnum, dataCriacao, dataAtualizacao);
        this.matricula = matricula;
        this.curso = curso;
        this.istituicao = istituicao;
        this.usuarioStatusEnum = usuarioStatusEnum;

        // AQUI ESTÁ A CORREÇÃO
        this.userId = userId;
    }

    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }

    public String getCurso() { return curso; }
    public void setCurso(String curso) { this.curso = curso; }

    public String getIstituicao() { return istituicao; }
    public void setIstituicao(String istituicao) { this.istituicao = istituicao; }

    public UsuarioStatusEnum getUsuarioStatusEnum() { return usuarioStatusEnum; }
    public void setUsuarioStatusEnum(UsuarioStatusEnum usuarioStatusEnum) { this.usuarioStatusEnum = usuarioStatusEnum; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    // CONVERSÃO CORRIGIDA
    public Student toStudent() {
        return new Student(
                this.getMatricula(),
                this.getCurso(),
                this.getIstituicao(),
                this.getUsuarioStatusEnum(),
                this.getDataCriacao(),
                this.getDataAtualizacao(),
                this.getUserId(), // AQUI ESTAVA O ERRO
                null
        );
    }

    // CORREÇÃO NO FROMMODEL
    public static StudentEntitie fromStudent(Student student) {
        return new StudentEntitie(
                student.getId(),
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                student.getDataCriacao(),
                student.getDataAtualizacao(),
                student.getMatricula(),
                student.getCurso(),
                student.getIstituicao(),
                student.getUsuarioStatusEnum(),
                student.getUserId()
        );
    }
}
