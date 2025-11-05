package com.example.projeto_aerj.beta.entities.viagens;

import java.time.LocalDateTime;

public class AlunoViagem {

    private int id;
    private String descricao;
    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;

    public AlunoViagem(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
        this.dataCriacao = LocalDateTime.now();
        this.dataAtualizacao = LocalDateTime.now();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
        this.dataAtualizacao = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }
}
