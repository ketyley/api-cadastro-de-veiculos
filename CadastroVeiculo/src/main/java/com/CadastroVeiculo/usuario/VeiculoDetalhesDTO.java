package com.CadastroVeiculo.usuario;

import com.CadastroVeiculo.veiculo.Rodizio;
import com.CadastroVeiculo.veiculo.Veiculo;

import java.time.LocalDate;

public class VeiculoDetalhesDTO {
    private Long idVeiculo;
    private String marca;
    private String modelo;
    private String ano;
    private String valor;
    private String diaRodizio;
    private Boolean rodizioAtivo;

    public VeiculoDetalhesDTO(Veiculo veiculo) {
        this.idVeiculo = veiculo.getIdVeiculo();
        this.marca = veiculo.getMarca();
        this.modelo = veiculo.getModelo();
        this.ano = veiculo.getAno();
        this.valor = veiculo.getValor();

        int ultimoDigitoDoAno = veiculo.getAnoModelo() % 10;
        Rodizio rodizio = Rodizio.buscarDiaDeRodizio(ultimoDigitoDoAno);

        this.diaRodizio = rodizio.getDiaDaSemanaFormatado();
        this.rodizioAtivo = rodizio.rodizioAtivo();
    }

    public Long getIdVeiculo() {
        return idVeiculo;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getAno() {
        return ano;
    }

    public String getValor() {
        return valor;
    }

    public String getDiaRodizio() {
        return diaRodizio;
    }

    public Boolean getRodizioAtivo() {
        return rodizioAtivo;
    }
}
