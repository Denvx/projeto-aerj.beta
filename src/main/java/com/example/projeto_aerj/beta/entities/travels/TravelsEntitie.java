package com.example.projeto_aerj.beta.entities.travels;

import com.example.projeto_aerj.beta.models.Routes;
import com.example.projeto_aerj.beta.models.Travel;
import com.example.projeto_aerj.beta.models.Vehicle;

import java.time.LocalDateTime;

public class TravelsEntitie {

    private int id;
    private LocalDateTime dataViagem;
    private int veiculoId;
    private Vehicle veiculo;
    private int rotaId;
    private Routes routes;

    public TravelsEntitie() {
    }

    public TravelsEntitie(int id, LocalDateTime dataViagem, int veiculoId, Vehicle veiculo, int rotaId, Routes routes) {
        this.id = id;
        this.dataViagem = dataViagem;
        this.veiculoId = veiculoId;
        this.veiculo = veiculo;
        this.rotaId = rotaId;
        this.routes = routes;
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

    public Vehicle getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Vehicle veiculo) {
        this.veiculo = veiculo;
    }

    public int getRotaId() {
        return rotaId;
    }

    public void setRotaId(int rotaId) {
        this.rotaId = rotaId;
    }

    public Routes getRoutes() {
        return routes;
    }

    public void setRoutes(Routes routes) {
        this.routes = routes;
    }

    public Travel toModel(){
        return new Travel(
                this.getId(),
                this.getDataViagem(),
                this.getVeiculoId(),
                this.getVeiculo(),
                this.getRotaId(),
                null


        );
    }

    public static TravelsEntitie fromModel(Travel travel){
        return new TravelsEntitie(
                travel.getId(),
                travel.getDataViagem(),
                travel.getVeiculoId(),
                travel.getVeiculo(),
                travel.getRotaId(),
                null
        );
    }
}