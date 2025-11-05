package com.example.projeto_aerj.beta.entities.viagens;

import java.time.LocalTime;
import java.util.Date;

public class Viagem {
    private int id;
    private LocalTime horaSaida;
    private Date horaChegada;

    public Viagem(int id, LocalTime horaSaida, Date horaChegada) {
        this.id = id;
        this.horaSaida = horaSaida;
        this.horaChegada = horaChegada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalTime getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(LocalTime horaSaida) {
        this.horaSaida = horaSaida;
    }

    public Date getHoraChegada() {
        return horaChegada;
    }

    public void setHoraChegada(Date horaChegada) {
        this.horaChegada = horaChegada;
    }
}
