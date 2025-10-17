package com.example.projeto_aerj.beta.enums;

public enum StudentStatusEnum {
    ADIMPLENTE("Adipmlente"),
    INADIMPLENTE("Inadiplente"),
    TRANCADO("Trancado"),
    EGRESSO("Egresso");

    private final String statusAdiplencia;

    StudentStatusEnum(String statusAdiplencia) {
        this.statusAdiplencia = statusAdiplencia;
    }

    public String getStatusAdiplencia() {
        return statusAdiplencia;
    }
}
