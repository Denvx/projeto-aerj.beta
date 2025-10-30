package com.example.projeto_aerj.beta.Models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "endereco")
public class EnderecoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "UsuarioId")
    private Long usuarioId;

    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String cep;

    @Column(updatable = false)
    private LocalDateTime dataRegistrada;

    private LocalDateTime dataAtualizacao;

    public EnderecoModel() {
    }

    public EnderecoModel(String logradouro, String numero, String bairro, String cidade, String cep) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
    }

    @PrePersist
    protected void onCreate() {
        this.dataRegistrada = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.dataAtualizacao = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getCep() {
        return cep;
    }

    public LocalDateTime getDataRegistrada() {
        return dataRegistrada;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}