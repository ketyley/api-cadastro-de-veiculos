package com.CadastroVeiculo.usuario;

import com.CadastroVeiculo.veiculo.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    boolean existsByEmail(String email);

    boolean existsByCpf(String cpf);
}
