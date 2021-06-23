package com.CadastroVeiculo.veiculo;

import com.CadastroVeiculo.usuario.UsuarioForm;

import javax.validation.constraints.NotBlank;

public class VeiculoForm {

    @NotBlank
    private String marca;
    @NotBlank
    private String modelo;
    @NotBlank
    private String ano;

    public VeiculoForm(String marca, String modelo, String ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
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

    public Veiculo transformarEmVeiculo(String valor, Long idUsuario,Integer anoModelo){
        return new Veiculo(marca,modelo,ano,valor,idUsuario,anoModelo);
    }
}
