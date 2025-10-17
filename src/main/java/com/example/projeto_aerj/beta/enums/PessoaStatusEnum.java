package com.example.projeto_aerj.beta.enums;

public enum PessoaStatusEnum {
    ATIVO("Ativo"),
    INATIVO("Inativo");

    private final String status;

    PessoaStatusEnum(String descricao) {
        this.status = descricao;
    }

    public String getDescricao() {
        return status;
    }
}