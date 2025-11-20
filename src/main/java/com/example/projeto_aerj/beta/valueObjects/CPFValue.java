package com.example.projeto_aerj.beta.valueObjects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;

@Embeddable
public class CPFValue {

    private String cpf;

    public CPFValue() {
    }

    public CPFValue(String receivedCpf) {
        if (receivedCpf == null || receivedCpf.trim().isEmpty()) {
            throw new IllegalArgumentException("CPF não pode ser nulo ou vazio");
        }

        // Remove formatação (pontos e traço)
        String cpfLimpo = receivedCpf.replaceAll("[.\\-]", "").trim();

        if (!isValid(cpfLimpo)) {
            throw new IllegalArgumentException("CPF inválido: " + receivedCpf);
        }

        // Armazena apenas os números
        this.cpf = cpfLimpo;
    }

    private boolean isValid(String cpf) {
        // Verifica se tem 11 dígitos numéricos
        if (cpf == null || !cpf.matches("\\d{11}")) {
            return false;
        }

        // Rejeita CPFs com todos os dígitos iguais
        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        // Valida os dois dígitos verificadores
        try {
            // Calcula o primeiro dígito verificador
            int soma = 0;
            for (int i = 0; i < 9; i++) {
                soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
            }
            int primeiroDigito = 11 - (soma % 11);
            if (primeiroDigito >= 10) primeiroDigito = 0;

            // Verifica o primeiro dígito
            if (Character.getNumericValue(cpf.charAt(9)) != primeiroDigito) {
                return false;
            }

            // Calcula o segundo dígito verificador
            soma = 0;
            for (int i = 0; i < 10; i++) {
                soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
            }
            int segundoDigito = 11 - (soma % 11);
            if (segundoDigito >= 10) segundoDigito = 0;

            // Verifica o segundo dígito
            return Character.getNumericValue(cpf.charAt(10)) == segundoDigito;

        } catch (Exception e) {
            return false;
        }
    }

    @JsonIgnore
    public String getFormatted() {
        if (cpf == null || cpf.length() != 11) {
            return cpf;
        }
        return cpf.substring(0, 3) + "." +
                cpf.substring(3, 6) + "." +
                cpf.substring(6, 9) + "-" +
                cpf.substring(9);
    }

    // Métodos específicos para JSON
    @JsonProperty("numero")
    public String getNumero() {
        return cpf;
    }

    @JsonProperty("numero")
    public void setNumero(String receivedCpf) {
        if (receivedCpf == null || receivedCpf.trim().isEmpty()) {
            this.cpf = null;
            return;
        }

        String cpfLimpo = receivedCpf.replaceAll("[.\\-]", "").trim();

        if (!isValid(cpfLimpo)) {
            throw new IllegalArgumentException("CPF inválido: " + receivedCpf);
        }

        this.cpf = cpfLimpo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CPFValue cpfValue = (CPFValue) o;
        return cpf != null && cpf.equals(cpfValue.cpf);
    }

    @Override
    public int hashCode() {
        return cpf != null ? cpf.hashCode() : 0;
    }

    @Override
    public String toString() {
        return getFormatted();
    }

    @JsonIgnore
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}