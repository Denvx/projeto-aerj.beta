package com.example.projeto_aerj.beta.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "routes")
public class Routes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String origem;
    private String destino;
    private String tempoEstimado;
    private LocalDateTime dataCriacao;

    @JsonIgnore
    @OneToMany(mappedBy = "routes", cascade = CascadeType.ALL)
    private List<Travel> travels = new ArrayList<>();

    public Routes() {
    }

    public Routes(int id, String origem, String destino, String tempoEstimado, LocalDateTime dataCriacao, List<Travel> travels) {
        this.id = id;
        this.origem = origem;
        this.destino = destino;
        this.tempoEstimado = tempoEstimado;
        this.dataCriacao = dataCriacao;
        this.travels = travels;
    }

    @PrePersist
    protected void onCreate() {
        this.dataCriacao = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getTempoEstimado() {
        return tempoEstimado;
    }

    public void setTempoEstimado(String tempoEstimado) {
        this.tempoEstimado = tempoEstimado;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public List<Travel> getTravels() {
        return travels;
    }

    public void setTravels(List<Travel> travels) {
        this.travels = travels;
    }
}