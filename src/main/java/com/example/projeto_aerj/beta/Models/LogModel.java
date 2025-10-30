package com.example.projeto_aerj.beta.Models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Log")
public class LogModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_log_id", referencedColumnName = "id", unique = true)
    private UsuarioModel usuarioModel;

    private String acao;

    @Column(updatable = false)
    private LocalDateTime dataRegistrada;

    public LogModel() {
    }

    public LogModel(int id, String acao, LocalDateTime dataRegistrada) {
        this.id = id;
        this.acao = acao;

        this.dataRegistrada = dataRegistrada;
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

    public UsuarioModel getUsuarioModel() {
        return usuarioModel;
    }

    public void setUsuarioModel(UsuarioModel usuarioModel) {
        this.usuarioModel = usuarioModel;
    }

    public void setDataRegistrada(LocalDateTime dataRegistrada) {
        this.dataRegistrada = dataRegistrada;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public LocalDateTime getDataRegistrada() {
        return dataRegistrada;
    }

    @PrePersist
    protected void onCreate() {
        this.dataRegistrada = LocalDateTime.now();
    }
}


