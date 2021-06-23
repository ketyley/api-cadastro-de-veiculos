package com.CadastroVeiculo.client;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Optional;

public class BuscaModeloResponseWrapper {

    @JsonProperty("modelos")
    private List<BuscaModeloResponse> modelos;

    public void setModelos(List<BuscaModeloResponse> modelos) {
        this.modelos = modelos;
    }

    public Optional<String> buscarCodigoDoModelo(String modelo) {
        return modelos
                .stream()
                .filter(modeloResponse -> modeloResponse.getNome().equals(modelo))
                .map(BuscaModeloResponse::getCodigo)
                .findFirst();
    }
}
