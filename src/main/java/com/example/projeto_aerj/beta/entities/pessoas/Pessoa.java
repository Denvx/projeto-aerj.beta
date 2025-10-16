package com.example.projeto_aerj.beta.entities.pessoas;

import com.example.projeto_aerj.beta.enums.AtivosEnum;
import com.example.projeto_aerj.beta.valueObjects.CPFValue;
import com.example.projeto_aerj.beta.valueObjects.EmailValue;
import com.example.projeto_aerj.beta.enums.SexoEnum;
import java.time.ZonedDateTime;
import java.util.Date;

public class Pessoa {

    private long id;
    private String nome;
    private Date dataNascimento;
    private EmailValue emailValue;
    private String telefone;
    private CPFValue cpfValue;
    private SexoEnum sexoEnum;
    private AtivosEnum ativosEnum;
    private ZonedDateTime dataCriacao;
    private ZonedDateTime dataAtualizacao;

    public Pessoa() {}

    public Pessoa(long id, String nome, Date dataNascimento, EmailValue emailValue, String telefone, CPFValue cpfValue, SexoEnum sexoEnum, AtivosEnum ativosEnum, ZonedDateTime dataCriacao, ZonedDateTime dataAtualizacao) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.emailValue = emailValue;
        this.telefone = telefone;
        this.cpfValue = cpfValue;
        this.sexoEnum = sexoEnum;
        this.ativosEnum = ativosEnum;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public CPFValue getCpfValue() {
        return cpfValue;
    }

    public void setCpfValue(CPFValue cpfValue) {
        this.cpfValue = cpfValue;
    }

    public SexoEnum getSexoEnum() {
        return sexoEnum;
    }

    public void setSexoEnum(SexoEnum sexoEnum) {
        this.sexoEnum = sexoEnum;
    }

    public AtivosEnum getAtivosEnum() {
        return ativosEnum;
    }

    public void setAtivosEnum(AtivosEnum ativosEnum) {
        this.ativosEnum = ativosEnum;
    }

    public ZonedDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(ZonedDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public ZonedDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(ZonedDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}
