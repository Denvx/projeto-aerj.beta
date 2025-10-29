package com.example.projeto_aerj.beta.entities.viagens;

import com.example.projeto_aerj.beta.enums.StatusViagemEnum;

public class StatusViagem {

    private long id;
    private StatusViagemEnum statusViagemEnum;

    public StatusViagem(long id, StatusViagemEnum statusViagemEnum) {
        this.id = id;
        this.statusViagemEnum = statusViagemEnum;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public StatusViagemEnum getStatusViagemEnum() {
        return statusViagemEnum;
    }

    public void setStatusViagemEnum(StatusViagemEnum statusViagemEnum) {
        this.statusViagemEnum = statusViagemEnum;
    }
}
