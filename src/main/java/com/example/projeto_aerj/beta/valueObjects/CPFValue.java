package com.example.projeto_aerj.beta.valueObjects;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;

@Embeddable
public class CPFValue {

    private String cpf;

    public CPFValue() {}

    public CPFValue(String cpf) {
        setCpf(cpf);
    }

    @JsonProperty("cpf")
    public String getCpf() {
        return cpf;
    }

    @JsonProperty("cpf")
    public void setCpf(String receivedCpf) {
        if (receivedCpf == null || receivedCpf.isBlank()) {
            throw new IllegalArgumentException("CPF não pode ser nulo ou vazio");
        }

        // remove pontos e traço
        String cleaned = receivedCpf.replaceAll("[^0-9]", "");

        // valida se tem 11 dígitos
        if (!cleaned.matches("\\d{11}")) {
            throw new IllegalArgumentException("CPF inválido");
        }

        this.cpf = cleaned;
    }
}
