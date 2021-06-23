package com.CadastroVeiculo.usuario;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class UsuarioComVeiculosDTO {

    private String nome;
    private String email;
    private String cpf;
    private LocalDate dtNascimento;
    private List<VeiculoDetalhesDTO> veiculos;

    public UsuarioComVeiculosDTO(Usuario usuario) {
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.cpf = usuario.getCpf();
        this.dtNascimento = usuario.getDtNascimento();
        this.veiculos = usuario.getVeiculos()
                .stream()
                .map(VeiculoDetalhesDTO::new)
                .collect(Collectors.toList());
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

    public List<VeiculoDetalhesDTO> getVeiculos() {
        return veiculos;
    }
}
