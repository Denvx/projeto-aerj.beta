package com.example.projeto_aerj.beta.entities.auditorias;

import java.time.LocalDateTime;

public class Log {

    private int id;
    private String acao;
    private LocalDateTime dataRegistrada;

    public Log(int id, String acao, LocalDateTime dataRegistrada) {
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

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public LocalDateTime getDataRegistrada() {
        return dataRegistrada;
    }

    public void setDataRegistrada(LocalDateTime dataRegistrada) {
        this.dataRegistrada = dataRegistrada;
    }
}
