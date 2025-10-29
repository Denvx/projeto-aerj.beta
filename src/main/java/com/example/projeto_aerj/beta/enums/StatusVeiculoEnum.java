package com.example.projeto_aerj.beta.enums;

public enum StatusVeiculoEnum {
    DISPONIVEL("Disponivel"),
    EM_ROTA("Em Rota"),
    EM_MANUTENCAO("Em Manutenção"),
    INATIVO("Inativo");

    private final String statusVeiculo;
    StatusVeiculoEnum(String statusVeiculo) {
        this.statusVeiculo = statusVeiculo;
    }

    public String getStatusVeiculo() {
        return statusVeiculo;
    }
}
