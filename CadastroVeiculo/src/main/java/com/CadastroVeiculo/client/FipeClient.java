package com.CadastroVeiculo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "client", url = "https://parallelum.com.br/fipe/api/v1/carros")
public interface FipeClient {

    @GetMapping("/marcas")
    List<BuscaMarcaResponse> buscarMarcas();

    @GetMapping("/marcas/{idMarca}/modelos")
    BuscaModeloResponseWrapper buscarModelos(@PathVariable String idMarca);

    @GetMapping("/marcas/{idMarca}/modelos/{idModelo}/anos")
    List<BuscaAnoResponse> buscarAnos(@PathVariable String idMarca,
                                      @PathVariable String idModelo);

    @GetMapping("/marcas/{idMarca}/modelos/{idModelo}/anos/{ano}")
    BuscaValorResponse buscarValor(@PathVariable String idMarca,
                                   @PathVariable String idModelo,
                                   @PathVariable String ano);
}

