package com.example.projeto_aerj.beta.Models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "aviso")
public class AvisoModel {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "usuario_id")
    private int usuarioId;

    @OneToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", insertable = false, updatable = false, unique = true)
    private UsuarioModel usuarioModel;

    private String mensagem;
    private LocalDateTime dataEnvio;

    public AvisoModel(int id, String mensagem, LocalDateTime dataEnvio) {
        this.id = id;
        this.mensagem = mensagem;
        this.dataEnvio = dataEnvio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public LocalDateTime getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(LocalDateTime dataEnvio) {
        this.dataEnvio = dataEnvio;
    }
}
