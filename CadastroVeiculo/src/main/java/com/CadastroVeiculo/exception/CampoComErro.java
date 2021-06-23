package com.CadastroVeiculo.exception;

public class CampoComErro {

    private String campo;
    private String erro;

    public CampoComErro(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }

    public String getCampo() {
        return campo;
    }

    public String getErro() {
        return erro;
    }
}

