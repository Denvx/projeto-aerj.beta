package com.example.projeto_aerj.beta.entities.address;

import com.example.projeto_aerj.beta.models.Address;

import java.time.LocalDateTime;

public class AddressEntitie {
    
    private int id;
    private String logradouro;
    private String numeroCasa;
    private String bairro;
    private String cidade;
    private int cep;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;

    public AddressEntitie() {
    }

    public AddressEntitie(String logradouro, String numeroCasa, String bairro, String cidade, int cep, LocalDateTime dataCriacao, LocalDateTime dataAtualizacao) {
        this.logradouro = logradouro;
        this.numeroCasa = numeroCasa;
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
    }

    public String getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(String numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
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

    public Address toModel(){
        return new Address(
                this.getLogradouro(),
                this.getNumeroCasa(),
                this.getBairro(),
                this.getCidade(),
                this.getCep(),
                this.getDataCriacao(),
                this.getDataAtualizacao()
        );
    }

    public static AddressEntitie toModel(Address a) {
        return new AddressEntitie(
                a.getLogradouro(),
                a.getNumeroCasa(),
                a.getBairro(),
                a.getCidade(),
                a.getCep(),
                a.getDataCriacao(),
                a.getDataAtualizacao()
        );
    }
}