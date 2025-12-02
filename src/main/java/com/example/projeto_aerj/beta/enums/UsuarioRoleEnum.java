package com.example.projeto_aerj.beta.enums;

public enum UsuarioRoleEnum {
    ADIMIN("Adimin"),
    ALUNO("Aluno");

    private final String role;

    UsuarioRoleEnum(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}