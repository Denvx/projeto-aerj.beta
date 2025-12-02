package com.example.projeto_aerj.beta.enums;

public enum StatusPagamentoEnum {
    PENDENTE("Pendente"),
    PROCESSANDO("Processando"),
    PAGO("Pago"),
    CANCELADO("Cancelado");

    private final String statusPagamento;

    StatusPagamentoEnum(String statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public String getStatusPagamento(){
        return statusPagamento;
    }
}