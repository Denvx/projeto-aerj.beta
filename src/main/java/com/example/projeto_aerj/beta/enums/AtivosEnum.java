package com.example.projeto_aerj.beta.enums;

public enum AtivosEnum {
    ATIVO("Ativo"),
    INATIVO("Inativo"),
    SUSPENSO("Suspenso"); // caso queira

    private final String descricao;

    AtivosEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}