package com.example.projeto_aerj.beta.entities.pagamentos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Pagamento {

    private int id;
    private LocalDateTime data;
    private BigDecimal valor;

    public Pagamento(int id, LocalDateTime data, BigDecimal valor) {
        this.id = id;
        this.data = data;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
