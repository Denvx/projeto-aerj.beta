package com.example.projeto_aerj.beta.enums;

public enum StatusViagemEnum {
    AGENDADA ("Agendada"),
    CONFIRMADA("Confirmada"),
    EM_ANDAMENTO("Em Andamento"),
    CONCLUIDA("Concluida");

    private final String StatusViagem;

    StatusViagemEnum(String statusViagem) {
        StatusViagem = statusViagem;
    }

    public String getStatusViagem() {
        return StatusViagem;
    }
}