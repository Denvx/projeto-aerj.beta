package com.example.projeto_aerj.beta.entities.viagens;

import java.time.LocalDateTime;

public class AlunoViagem {

    private long id;
    private String descricao;
    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;

    public AlunoViagem(long id, String descricao, LocalDateTime dataCriacao) {
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
}
