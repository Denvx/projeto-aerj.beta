package com.example.projeto_aerj.beta.entities.person;

import com.example.projeto_aerj.beta.enums.UsuarioRoleEnum;
import com.example.projeto_aerj.beta.enums.UsuarioSexoEnum;
import com.example.projeto_aerj.beta.models.User;
import com.example.projeto_aerj.beta.valueObjects.CPFValue;
import com.example.projeto_aerj.beta.valueObjects.EmailValue;
import java.util.Date;

public class UserEntitie {

    private int id;
    private String name;
    private CPFValue cpfValue;
    private Date dataNascimento;
    private EmailValue emailValue;
    private UsuarioSexoEnum usuarioSexoEnum;
    private String senhaHash;
    private UsuarioRoleEnum roleEnum;
    private Date dataCriacao;
    private Date dataAtualizacao;

    public UserEntitie() {
    }

    public UserEntitie(int id, String name, CPFValue cpfValue, Date dataNascimento, EmailValue emailValue, UsuarioSexoEnum usuarioSexoEnum, String senhaHash, UsuarioRoleEnum roleEnum, Date dataCriacao, Date dataAtualizacao) {
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

    public void atualizarDataModificacao() {
        this.dataAtualizacao = new Date();
    }

    public void definirDataCriacao() {
        if (this.dataCriacao == null) {
            this.dataCriacao = new Date();
            this.dataAtualizacao = new Date();
        }
    }

    public User toUser(){
        return new User(
                this.getId(),
                this.getName(),
                this.getCpfValue(),
                this.getDataNascimento(),
                this.getEmailValue(),
                this.getUsuarioSexoEnum(),
                this.getSenhaHash(),
                this.getRoleEnum(),
                this.getDataCriacao(),
                this.getDataAtualizacao()
        );
    }

    public static UserEntitie fromUser(User user){
        return new UserEntitie(
                user.getId(),
                user.getName(),
                user.getCpfValue(),
                user.getDataNascimento(),
                user.getEmailValue(),
                user.getUsuarioSexoEnum(),
                user.getSenhaHash(),
                user.getRoleEnum(),
                user.getDataCriacao(),
                user.getDataAtualizacao()
        );
    }
}
