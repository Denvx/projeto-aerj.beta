package com.example.projeto_aerj.beta.entities.viagens;

import com.example.projeto_aerj.beta.enums.StatusViagemEnum;

public class StatusAlunoViagem {

    private int id;
    private StatusViagemEnum statusViagemEnum;

    public StatusAlunoViagem(int id, StatusViagemEnum statusViagemEnum) {
        this.id = id;
        this.statusViagemEnum = statusViagemEnum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StatusViagemEnum getStatusViagemEnum() {
        return statusViagemEnum;
    }

    public void setStatusViagemEnum(StatusViagemEnum statusViagemEnum) {
        this.statusViagemEnum = statusViagemEnum;
    }
}
