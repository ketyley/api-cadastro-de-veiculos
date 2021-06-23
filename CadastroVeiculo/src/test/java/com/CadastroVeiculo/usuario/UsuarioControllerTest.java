package com.CadastroVeiculo.usuario;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioControllerTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @Autowired
    @InjectMocks
    private UsuarioController usuarioController;

    @Test
    public void deveRetornarErroQuandoEmailJaExistente() {
        UsuarioForm usuarioForm = new UsuarioForm("nome", "email", "cpf");
        UriComponentsBuilder uriComponentsBuilder = Mockito.mock(UriComponentsBuilder.class);

        Mockito.when(usuarioRepository.existsByEmail(Mockito.any()))
                .thenReturn(true);

        ResponseEntity response = usuarioController.salvar(uriComponentsBuilder, usuarioForm);

        Assert.assertEquals("Email já cadastrado, por favor insira um novo.", response.getBody());
        Mockito.verify(usuarioRepository, Mockito.times(0)).save(Mockito.any());
    }

    @Test
    public void deveRetornarErroQuandoCpfJaExistente() {
        UsuarioForm usuarioForm = new UsuarioForm("nome", "email", "cpf");
        UriComponentsBuilder uriComponentsBuilder = Mockito.mock(UriComponentsBuilder.class);

        Mockito.when(usuarioRepository.existsByCpf(Mockito.any()))
                .thenReturn(true);

        ResponseEntity response = usuarioController.salvar(uriComponentsBuilder, usuarioForm);

        Assert.assertEquals("CPF já cadastrado, por favor insira um novo.", response.getBody());
        Mockito.verify(usuarioRepository, Mockito.times(0)).save(Mockito.any());
    }

}