package com.CadastroVeiculo.veiculo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVeiculo;
    private String marca;
    private String modelo;
    private String ano;
    private String valor;
    private Long idUsuario;
    private Integer anoModelo;

    /**
     * constructor para uso exclusivo do Hibernate
     */
    @Deprecated
    public Veiculo() {
    }

    public Veiculo(String marca, String modelo, String ano, String valor, 
                   Long idUsuario,Integer anoModelo) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.valor = valor;
        this.idUsuario = idUsuario;
        this.anoModelo = anoModelo;
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

    public Long getIdUsuario() {
        return idUsuario;
    }

    public Integer getAnoModelo() {
        return anoModelo;
    }
}
