package com.example.projeto_aerj.beta.enums;

public enum PessoaSexoEnum {
    MASCULINO("Masculino"),
    FEMININO("Feminino"),
    OUTRO("Outro");

    private final String sexo;

    PessoaSexoEnum(String descricao) {
        this.sexo = descricao;
    }

    public String getDescricao() {
        return sexo;
    }
}