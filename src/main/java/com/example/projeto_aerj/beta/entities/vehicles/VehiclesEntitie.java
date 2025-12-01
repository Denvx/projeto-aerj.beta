package com.example.projeto_aerj.beta.entities.vehicles;

import com.example.projeto_aerj.beta.enums.StatusVeiculoEnum;
import com.example.projeto_aerj.beta.models.Travel;
import com.example.projeto_aerj.beta.models.Vehicle;

import java.time.LocalDateTime;
import java.util.List;

public class VehiclesEntitie {

    private int id;
    private String placa;
    private String modelo;
    private int capacidade;
    private StatusVeiculoEnum statusVeiculoEnum;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;

    public VehiclesEntitie() {
    }

    public VehiclesEntitie(int id, String placa, String modelo, int capacidade, StatusVeiculoEnum statusVeiculoEnum, LocalDateTime dataCriacao, LocalDateTime dataAtualizacao) {
        this.id = id;
        this.placa = placa;
        this.modelo = modelo;
        this.capacidade = capacidade;
        this.statusVeiculoEnum = statusVeiculoEnum;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public StatusVeiculoEnum getStatusVeiculoEnum() {
        return statusVeiculoEnum;
    }

    public void setStatusVeiculoEnum(StatusVeiculoEnum statusVeiculoEnum) {
        this.statusVeiculoEnum = statusVeiculoEnum;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }



    public Vehicle toModel(){
        return new Vehicle(
                this.getId(),
                this.getPlaca(),
                this.getModelo(),
                this.getCapacidade(),
                this.getStatusVeiculoEnum(),
                this.getDataCriacao(),
                this.getDataAtualizacao()
        );
    }

    public static VehiclesEntitie fromModel (Vehicle v){
        return new VehiclesEntitie(
                v.getId(),
                v.getPlaca(),
                v.getModelo(),
                v.getCapacidade(),
                v.getStatusVeiculoEnum(),
                v.getDataCriacao(),
                v.getDataAtualizacao()
        );
    }
}