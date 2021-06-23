package com.CadastroVeiculo.client;

public class BuscaModeloResponse {

    private String nome;
    private String codigo;

    public BuscaModeloResponse(String nome, String codigo) {
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
