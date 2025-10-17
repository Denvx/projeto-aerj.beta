package com.example.projeto_aerj.beta.enums;

public enum PessoaStatusEnum {
    ATIVO("Ativo"),
    INATIVO("Inativo");

    private final String descricao;

    PessoaStatusEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}