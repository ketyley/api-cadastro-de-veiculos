package com.CadastroVeiculo.client;

public class BuscaAnoResponse {

    private String nome;
    private String codigo;

    public BuscaAnoResponse(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }
}

