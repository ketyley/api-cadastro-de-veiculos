package com.CadastroVeiculo.usuario;

import java.time.LocalDate;

public class UsuarioDTO {
    private String nome;
    private String email;
    private String cpf;
    private LocalDate dtNascimento;

    public UsuarioDTO(Usuario usuario) {
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.cpf = usuario.getCpf();
        this.dtNascimento = usuario.getDtNascimento();
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDtNascimento() {
        return dtNascimento;
    }
}
