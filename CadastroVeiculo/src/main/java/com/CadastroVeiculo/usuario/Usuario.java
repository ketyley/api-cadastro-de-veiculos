package com.CadastroVeiculo.usuario;

import com.CadastroVeiculo.veiculo.Veiculo;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    private String nome;
    private String email;
    private String cpf;
    private LocalDate dtNascimento;

    @OneToMany
    @JoinColumn(name = "idUsuario")
    private List<Veiculo> veiculos;

    /**
     * constructor para uso exclusivo do Hibernate
     */
    @Deprecated
    public Usuario() {
    }

    public Usuario(String nome, String email, String cpf, LocalDate dtNascimento) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dtNascimento = dtNascimento;
    }

    public Long getIdUsuario() {
        return idUsuario;
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

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }
}
