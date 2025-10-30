package com.example.projeto_aerj.beta.enums;

public enum UsuarioSexoEnum {
    MASCULINO("Masculino"),
    FEMININO("Feminino"),
    OUTRO("Outro");

    private final String sexo;

    UsuarioSexoEnum(String descricao) {
        this.sexo = descricao;
    }

    public String getDescricao() {
        return sexo;
    }
}