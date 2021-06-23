package com.CadastroVeiculo.usuario;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.LocalDate;

public class UsuarioForm {

    @NotBlank
    private String nome;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @CPF
    private String cpf;

    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    @Past
    private LocalDate dtNascimento;

    public UsuarioForm(String nome, String email, String cpf) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }

    public void setDtNascimento(LocalDate dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public Usuario transformarEmUsuario() {
        return new Usuario(nome,email,cpf,dtNascimento);
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }
}
