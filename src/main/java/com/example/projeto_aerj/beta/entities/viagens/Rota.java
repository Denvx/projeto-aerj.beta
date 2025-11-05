package com.example.projeto_aerj.beta.entities.viagens;

public class Rota {

    private int id;
    private String origem;
    private String destino;
    private String duracaoEstimada;

    public Rota(int id, String origem, String destino, String duracaoEstimada) {
        this.id = id;
        this.origem = origem;
        this.destino = destino;
        this.duracaoEstimada = duracaoEstimada;
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

    public String getDuracaoEstimada() {
        return duracaoEstimada;
    }

    public void setDuracaoEstimada(String duracaoEstimada) {
        this.duracaoEstimada = duracaoEstimada;
    }
}
