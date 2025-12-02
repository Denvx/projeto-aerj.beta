package com.example.projeto_aerj.beta.enums;

public enum StatusVeiculoEnum {
    DISPONIVEL("Disponivel"),
    INDISPONIVEL("Indisponivel");

    private final String statusVeiculo;
    StatusVeiculoEnum(String statusVeiculo) {
        this.statusVeiculo = statusVeiculo;
    }

    public String getStatusVeiculo() {
        return statusVeiculo;
    }
}