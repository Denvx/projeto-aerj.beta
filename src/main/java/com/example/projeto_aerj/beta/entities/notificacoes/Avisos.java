package com.example.projeto_aerj.beta.entities.notificacoes;

import java.time.LocalDateTime;
import java.util.Date;

public class Avisos {

    private long id;
    private String mensagem;
    private LocalDateTime dataEnvio;

    public Avisos(long id, String mensagem, LocalDateTime dataEnvio) {
        this.id = id;
        this.mensagem = mensagem;
        this.dataEnvio = dataEnvio;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
