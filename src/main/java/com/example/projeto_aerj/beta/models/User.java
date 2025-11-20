package com.example.projeto_aerj.beta.models;

import com.example.projeto_aerj.beta.enums.UsuarioRoleEnum;
import com.example.projeto_aerj.beta.enums.UsuarioSexoEnum;
import com.example.projeto_aerj.beta.valueObjects.CPFValue;
import com.example.projeto_aerj.beta.valueObjects.EmailValue;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Embedded
    @JsonUnwrapped
    private CPFValue cpfValue;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataNascimento;

    @Embedded
    @JsonUnwrapped
    private EmailValue emailValue;

    @Enumerated(EnumType.STRING)
    private UsuarioSexoEnum usuarioSexoEnum;

    private String senhaHash;

    @Enumerated(EnumType.STRING)
    private UsuarioRoleEnum roleEnum;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;

    public User() {
    }

    public User(int id, String name, CPFValue cpfValue, Date dataNascimento, EmailValue emailValue, UsuarioSexoEnum usuarioSexoEnum, String senhaHash, UsuarioRoleEnum roleEnum, Date dataCriacao, Date dataAtualizacao) {
        this.id = id;
        this.name = name;
        this.cpfValue = cpfValue;
        this.dataNascimento = dataNascimento;
        this.emailValue = emailValue;
        this.usuarioSexoEnum = usuarioSexoEnum;
        this.senhaHash = senhaHash;
        this.roleEnum = roleEnum;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CPFValue getCpfValue() {
        return cpfValue;
    }

    public void setCpfValue(CPFValue cpfValue) {
        this.cpfValue = cpfValue;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public EmailValue getEmailValue() {
        return emailValue;
    }

    public void setEmailValue(EmailValue emailValue) {
        this.emailValue = emailValue;
    }

    public UsuarioSexoEnum getUsuarioSexoEnum() {
        return usuarioSexoEnum;
    }

    public void setUsuarioSexoEnum(UsuarioSexoEnum usuarioSexoEnum) {
        this.usuarioSexoEnum = usuarioSexoEnum;
    }

    public String getSenhaHash() {
        return senhaHash;
    }

    public void setSenhaHash(String senhaHash) {
        this.senhaHash = senhaHash;
    }

    public UsuarioRoleEnum getRoleEnum() {
        return roleEnum;
    }

    public void setRoleEnum(UsuarioRoleEnum roleEnum) {
        this.roleEnum = roleEnum;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}
