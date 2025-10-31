package com.example.projeto_aerj.beta.Models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Log")
public class LogModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "usuario_id")
    private int usuarioId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", insertable = false, updatable = false, unique = true)
    private UsuarioModel usuarioModel;

    private String acao;

    @Column(updatable = false)
    private LocalDateTime dataRegistrada;

    public LogModel() {
    }

    public LogModel(String acao) {
        this.acao = acao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public UsuarioModel getUsuarioModel() {
        return usuarioModel;
    }

    public void setUsuarioModel(UsuarioModel usuarioModel) {
        this.usuarioModel = usuarioModel;
    }

    public LocalDateTime getDataRegistrada() {
        return dataRegistrada;
    }

    @PrePersist
    protected void onCreate() {
        this.dataRegistrada = LocalDateTime.now();
    }
}