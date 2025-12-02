package com.example.projeto_aerj.beta.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "travels")
public class Travels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dataViagem;

    @Column(name = "veiculo_id")
    private int veiculoId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "veiculo_id", insertable = false, updatable = false)
    private Vehicles veiculo;

    public Travels() {
    }

    public Travels(int id, LocalDateTime dataViagem, int veiculoId, Vehicles veiculo) {
        this.id = id;
        this.dataViagem = dataViagem;
        this.veiculoId = veiculoId;
        this.veiculo = veiculo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDataViagem() {
        return dataViagem;
    }

    public void setDataViagem(LocalDateTime dataViagem) {
        this.dataViagem = dataViagem;
    }

    public int getVeiculoId() {
        return veiculoId;
    }

    public void setVeiculoId(int veiculoId) {
        this.veiculoId = veiculoId;
    }

    public Vehicles getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Vehicles veiculo) {
        this.veiculo = veiculo;
    }
}