package com.CadastroVeiculo.client;

public class BuscaMarcaResponse {

    private String nome;
    private String codigo;

    public BuscaMarcaResponse(String nome, String codigo) {
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
