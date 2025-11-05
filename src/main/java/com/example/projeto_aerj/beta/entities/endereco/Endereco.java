package com.example.projeto_aerj.beta.entities.endereco;

import java.time.LocalDateTime;

public class Endereco {
    private int id;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String cep;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;

    public Endereco(int id, String logradouro, String numero, String bairro, String cidade, String cep, LocalDateTime dataCriacao, LocalDateTime dataAtualizacao) {
        this.id = id;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
        this.dataAtualizacao = LocalDateTime.now();
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
        this.dataAtualizacao = LocalDateTime.now();
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
        this.dataAtualizacao = LocalDateTime.now();
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
        this.dataAtualizacao = LocalDateTime.now();
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
        this.dataAtualizacao = LocalDateTime.now();
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
}
