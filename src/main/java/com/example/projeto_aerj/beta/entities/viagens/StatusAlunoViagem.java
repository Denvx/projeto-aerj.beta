package com.example.projeto_aerj.beta.entities.viagens;

public class StatusAlunoViagem {

    private long id;
    private statusAlunoViagemEnum statusAlunoViagemEnum;

    public StatusAlunoViagem(long id, statusAlunoViagemEnum statusAlunoViagemEnum) {
        this.id = id;
        this.statusAlunoViagemEnum = statusAlunoViagemEnum;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public statusAlunoViagemEnum getStatusAlunoViagemEnum() {
        return statusAlunoViagemEnum;
    }

    public void setStatusAlunoViagemEnum(statusAlunoViagemEnum statusAlunoViagemEnum) {
        this.statusAlunoViagemEnum = statusAlunoViagemEnum;
    }
}
