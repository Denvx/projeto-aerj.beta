package com.example.projeto_aerj.beta.entities.pessoas;

import com.example.projeto_aerj.beta.enums.PessoaSexoEnum;
import com.example.projeto_aerj.beta.enums.PessoaStatusEnum;
import com.example.projeto_aerj.beta.enums.UsuarioRoleEnum;
import com.example.projeto_aerj.beta.enums.UsuarioStatusEnum;
import com.example.projeto_aerj.beta.valueObjects.CPFValue;
import com.example.projeto_aerj.beta.valueObjects.EmailValue;
import java.time.ZonedDateTime;
import java.util.Date;

public class Usuario extends Pessoa {
    private long idUser;
    private String nameUser;
    private String passoword;
    private UsuarioRoleEnum usuarioRoleEnum;
    private UsuarioStatusEnum usuarioStatusEnum;

    public Usuario(long id, String nome, Date dataNascimento, EmailValue emailValue, String telefone, CPFValue cpfValue, PessoaSexoEnum pessoaSexoEnum, PessoaStatusEnum pessoaStatusEnum, ZonedDateTime dataCriacao, ZonedDateTime dataAtualizacao, long idUser, String nameUser, String passoword, UsuarioRoleEnum usuarioRoleEnum, UsuarioStatusEnum usuarioStatusEnum) {
        super(idUser, nome, dataNascimento, emailValue, telefone, cpfValue, pessoaSexoEnum, pessoaStatusEnum, dataCriacao, dataAtualizacao);
        this.idUser = idUser;
        this.nameUser = nameUser;
        this.passoword = passoword;
        this.usuarioRoleEnum = usuarioRoleEnum;
        this.usuarioStatusEnum = usuarioStatusEnum;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getPassoword() {
        return passoword;
    }

    public void setPassoword(String passoword) {
        this.passoword = passoword;
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
}
