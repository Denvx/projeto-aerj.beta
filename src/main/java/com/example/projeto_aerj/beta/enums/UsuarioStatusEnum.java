package com.example.projeto_aerj.beta.enums;

public enum UsuarioStatusEnum {
    ATIVO("Ativo"),
    BLOQUEADO("Bloqueado"),
    BANIDO("Banido"),
    AGUARDANDOCONFIRMACAO("Aguardando Confirmação");

    private final String status;

    UsuarioStatusEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
