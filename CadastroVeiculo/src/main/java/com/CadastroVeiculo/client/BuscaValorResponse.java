package com.CadastroVeiculo.client;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class BuscaValorResponse {

    @JsonProperty("Valor")
    private String valor;
    @JsonProperty("AnoModelo")
    private Integer anoModelo;

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public Integer getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Integer ano) {
        this.anoModelo = ano;
    }
}

