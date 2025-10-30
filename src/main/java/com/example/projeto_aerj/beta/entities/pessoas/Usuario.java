package com.example.projeto_aerj.beta.entities.pessoas;

import com.example.projeto_aerj.beta.enums.UsuarioSexoEnum;
import com.example.projeto_aerj.beta.enums.UsuarioRoleEnum;
import com.example.projeto_aerj.beta.enums.UsuarioStatusEnum;
import com.example.projeto_aerj.beta.valueObjects.CPFValue;
import com.example.projeto_aerj.beta.valueObjects.EmailValue;

import java.time.LocalDateTime;
import java.util.Date;

public class Usuario{
    private int id;
    private String name;
    private CPFValue cpfValue;
    private Date dataNascimento;
    private String telefone;
    private EmailValue emailValue;
    private UsuarioSexoEnum usuarioSexoEnum;
    private UsuarioRoleEnum usuarioRoleEnum;
    private UsuarioStatusEnum usuarioStatusEnum;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;

    public Usuario(int id, String name, CPFValue cpfValue, Date dataNascimento, String telefone, EmailValue emailValue, UsuarioSexoEnum usuarioSexoEnum, UsuarioRoleEnum usuarioRoleEnum, UsuarioStatusEnum usuarioStatusEnum, LocalDateTime dataCriacao, LocalDateTime dataAtualizacao) {
        this.id = id;
        this.name = name;
        this.cpfValue = cpfValue;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.emailValue = emailValue;
        this.usuarioSexoEnum = usuarioSexoEnum;
        this.usuarioRoleEnum = usuarioRoleEnum;
        this.usuarioStatusEnum = usuarioStatusEnum;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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

    public UsuarioRoleEnum getUsuarioRoleEnum() {
        return usuarioRoleEnum;
    }

    public void setUsuarioRoleEnum(UsuarioRoleEnum usuarioRoleEnum) {
        this.usuarioRoleEnum = usuarioRoleEnum;
    }

    public UsuarioStatusEnum getUsuarioStatusEnum() {
        return usuarioStatusEnum;
    }

    public void setUsuarioStatusEnum(UsuarioStatusEnum usuarioStatusEnum) {
        this.usuarioStatusEnum = usuarioStatusEnum;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}
