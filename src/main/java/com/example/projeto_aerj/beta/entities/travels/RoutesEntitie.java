package com.example.projeto_aerj.beta.entities.travels;

import com.example.projeto_aerj.beta.models.Routes;
import com.example.projeto_aerj.beta.models.Travel;
import java.time.LocalDateTime;
import java.util.List;

public class RoutesEntitie {

    private int id;
    private String origem;
    private String destino;
    private String tempoEstimado;
    private LocalDateTime dataCriacao;
    private List<Travel> travels;

    public RoutesEntitie() {
    }

    public RoutesEntitie(int id, String origem, String destino, String tempoEstimado, LocalDateTime dataCriacao, List<Travel> travels) {
        this.id = id;
        this.origem = origem;
        this.destino = destino;
        this.tempoEstimado = tempoEstimado;
        this.dataCriacao = dataCriacao;
        this.travels = travels;
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

    public Routes toModel(){
        return new Routes(
                this.getId(),
                this.getOrigem(),
                this.getDestino(),
                this.getTempoEstimado(),
                this.getDataCriacao(),
                null

        );
    }

    public static RoutesEntitie fromModel(Routes routes){
        return new RoutesEntitie(
                routes.getId(),
                routes.getOrigem(),
                routes.getDestino(),
                routes.getTempoEstimado(),
                routes.getDataCriacao(),
                null
        );
    }
}
