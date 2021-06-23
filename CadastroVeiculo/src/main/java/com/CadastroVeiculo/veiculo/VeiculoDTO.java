package com.CadastroVeiculo.veiculo;

public class VeiculoDTO {
    private String marca;
    private String modelo;
    private String ano;
    private String valor;
    private Long idUsuario;


    public VeiculoDTO(Veiculo veiculo) {
        this.marca = veiculo.getMarca();
        this.modelo = veiculo.getModelo();
        this.ano = veiculo.getAno();
        this.valor = veiculo.getValor();
        this.idUsuario = veiculo.getIdUsuario();
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

    public Long getIdUsuario() {
        return idUsuario;
    }
}
