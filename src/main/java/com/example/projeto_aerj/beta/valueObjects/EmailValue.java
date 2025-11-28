package com.example.projeto_aerj.beta.valueObjects;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;

import java.util.regex.Pattern;

@Embeddable
public class EmailValue {

    private String email;

    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
    );

    public EmailValue() {}

    public EmailValue(String email) {
        setEmail(email);
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String receivedEmail) {
        if (receivedEmail == null || receivedEmail.isBlank()) {
            throw new IllegalArgumentException("Email não pode ser nulo ou vazio");
        }

        String formatted = receivedEmail.trim().toLowerCase();

        if (!EMAIL_PATTERN.matcher(formatted).matches()) {
            throw new IllegalArgumentException("Email inválido");
        }

        this.email = formatted;
    }
}