package com.example.projeto_aerj.beta.entities.pessoas;

import com.example.projeto_aerj.beta.enums.PessoaStatusEnum;
import com.example.projeto_aerj.beta.valueObjects.CPFValue;
import com.example.projeto_aerj.beta.valueObjects.EmailValue;
import com.example.projeto_aerj.beta.enums.PessoaSexoEnum;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

public class Pessoa {

    private long idPerson;
    private String name;
    private Date dataNascimento;
    private EmailValue emailValue;
    private String telefone;
    private CPFValue cpfValue;
    private PessoaSexoEnum pessoaSexoEnum;
    private PessoaStatusEnum pessoaStatusEnum;
    private ZonedDateTime dataCriacao;
    private ZonedDateTime dataAtualizacao;

    public Pessoa(long idPerson, String name, Date dataNascimento, EmailValue emailValue, String telefone, CPFValue cpfValue, PessoaSexoEnum pessoaSexoEnum, PessoaStatusEnum pessoaStatusEnum, ZonedDateTime dataCriacao, ZonedDateTime dataAtualizacao) {
        this.idPerson = idPerson;
        this.name = name;
        this.dataNascimento = dataNascimento;
        this.emailValue = emailValue;
        this.telefone = telefone;
        this.cpfValue = cpfValue;
        this.pessoaSexoEnum = pessoaSexoEnum;
        this.pessoaStatusEnum = pessoaStatusEnum;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
    }

    public long getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(long idPerson) {
        this.idPerson = idPerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public PessoaSexoEnum getSexoEnum() {
        return pessoaSexoEnum;
    }

    public void setSexoEnum(PessoaSexoEnum pessoaSexoEnum) {
        this.pessoaSexoEnum = pessoaSexoEnum;
    }

    public PessoaStatusEnum getAtivosEnum() {
        return pessoaStatusEnum;
    }

    public void setAtivosEnum(PessoaStatusEnum pessoaStatusEnum) {
        this.pessoaStatusEnum = pessoaStatusEnum;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao.toLocalDateTime();
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
