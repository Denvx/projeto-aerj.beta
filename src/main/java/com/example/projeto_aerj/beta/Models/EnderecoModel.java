package com.example.projeto_aerj.beta.Models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "endereco")
public class EnderecoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "usuario_id") //id que eu referencio onde vai ser criado e usado a fk
    private int usuarioId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", insertable = false, updatable = false, unique = true)
    private UsuarioModel usuarioModel;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UsuarioModel getUsuarioModel() {
        return usuarioModel;
    }

    public void setUsuarioModel(UsuarioModel usuarioModel) {
        this.usuarioModel = usuarioModel;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public LocalDateTime getDataRegistrada() {
        return dataRegistrada;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }
}