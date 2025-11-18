package com.example.projeto_aerj.beta.enums;

public enum StatusAlunoViagemEnum {
    VOU("Vou"),
    NAO_VOU("Nao vou"),
    PENDENTE("Pendente");

    private final String StatusAlunoViagem;

    StatusAlunoViagemEnum(String statusAlunoViagem) {
        StatusAlunoViagem = statusAlunoViagem;
    }

    public String getStatusAlunoViagem() {
        return StatusAlunoViagem;
    }
}