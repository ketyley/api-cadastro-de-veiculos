package com.CadastroVeiculo.usuario;

import com.CadastroVeiculo.exception.ApenasMensagemErro;
import com.CadastroVeiculo.exception.CampoComErro;
import com.CadastroVeiculo.exception.UsuarioNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/{idUsuario}")
    public ResponseEntity listarCarros(@PathVariable Long idUsuario) {
        Optional<Usuario> possivelUsuario = usuarioRepository.findById(idUsuario);

        if (!possivelUsuario.isPresent()){
            throw new UsuarioNaoEncontradoException(String
                    .format("Não foi encontrado um usuario com id %d, por favor utilize um usuário cadastrado", idUsuario));
        }

        UsuarioComVeiculosDTO usuarioComVeiculosDTO = new UsuarioComVeiculosDTO(possivelUsuario.get());

        return ResponseEntity.ok().body(usuarioComVeiculosDTO);
    }

    @PostMapping
    public ResponseEntity salvar(UriComponentsBuilder uriComponentsBuilder,
                                 @Valid @RequestBody UsuarioForm usuarioForm) {
        boolean existeEmail = usuarioRepository.existsByEmail(usuarioForm.getEmail());

        if (existeEmail) {
            return ResponseEntity.badRequest()
                    .body(new ApenasMensagemErro("Email já cadastrado, por favor insira um novo."));
        }
        boolean existeCPF = usuarioRepository.existsByCpf(usuarioForm.getCpf());

        if (existeCPF) {
            return ResponseEntity.badRequest()
                    .body(new ApenasMensagemErro("CPF já cadastrado, por favor insira um novo."));
        }

        Usuario usuario = usuarioForm.transformarEmUsuario();
        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        URI uriRecurso = uriComponentsBuilder
                .path("/usuarios/{idUsuario}")
                .build(usuarioSalvo.getIdUsuario());
        return ResponseEntity.created(uriRecurso).body(new UsuarioDTO(usuarioSalvo));
    }
}
