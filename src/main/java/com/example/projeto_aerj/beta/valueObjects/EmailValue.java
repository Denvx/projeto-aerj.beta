package com.example.projeto_aerj.beta.valueObjects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

import java.util.regex.Pattern;

@Embeddable
public class EmailValue {
    private String email;

    public EmailValue() {
    }

    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$" //
    );

    public EmailValue(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email não pode ser nulo ou vazio");
        }

        String emailToFormat = email.trim().toLowerCase();

        if (!EMAIL_PATTERN.matcher(emailToFormat).matches()) {
            throw new IllegalArgumentException("Email inválido: " + email);
        }

        this.email = emailToFormat;
    }

    public String getValue() {
        return email;
    }

    @Override
    public boolean equals(Object emailObject) {
        if (this == emailObject) return true;
        if (emailObject == null || getClass() != emailObject.getClass()) return false;
        EmailValue that = (EmailValue) emailObject;
        return email.equals(that.email);
    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }

    @Override
    public String toString() {
        return email;
    }
}