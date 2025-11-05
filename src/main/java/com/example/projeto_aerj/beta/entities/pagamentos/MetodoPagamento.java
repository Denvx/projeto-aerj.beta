package com.example.projeto_aerj.beta.entities.pagamentos;

import com.example.projeto_aerj.beta.enums.StatusPagamentoEnum;

public class MetodoPagamento {

    private int id;
    private String nome;
    private StatusPagamentoEnum statusPagamentoEnum;

    public MetodoPagamento(int id, String nome, StatusPagamentoEnum statusPagamentoEnum) {
        this.id = id;
        this.nome = nome;
        this.statusPagamentoEnum = statusPagamentoEnum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public StatusPagamentoEnum getStatusPagamentoEnum() {
        return statusPagamentoEnum;
    }

    public void setStatusPagamentoEnum(StatusPagamentoEnum statusPagamentoEnum) {
        this.statusPagamentoEnum = statusPagamentoEnum;
    }
}
