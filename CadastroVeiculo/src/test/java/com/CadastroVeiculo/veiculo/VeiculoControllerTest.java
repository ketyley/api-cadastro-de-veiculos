package com.CadastroVeiculo.veiculo;

import com.CadastroVeiculo.client.BuscaMarcaResponse;
import com.CadastroVeiculo.client.FipeClient;
import com.CadastroVeiculo.usuario.UsuarioController;
import com.CadastroVeiculo.usuario.UsuarioRepository;
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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@RunWith(MockitoJUnitRunner.class)
public class VeiculoControllerTest {

    @Mock
    private VeiculoRepository veiculoRepository;
    @Mock
    private FipeClient fipeClient;
    @Mock
    private UsuarioRepository usuarioRepository;

    @Autowired
    @InjectMocks
    private VeiculoController veiculoController;


    @Test
    public void deveRetornarErroQuandoUsuarioNaoExiste() {
        VeiculoForm usuarioForm = new VeiculoForm("marca", "modelo", "ano");
        UriComponentsBuilder uriComponentsBuilder = Mockito.mock(UriComponentsBuilder.class);
        Long idUsuario = 1L;

        Mockito.when(usuarioRepository.existsById(Mockito.any()))
                .thenReturn(false);

        ResponseEntity response = veiculoController.salvar(uriComponentsBuilder, idUsuario, usuarioForm);

        Assert.assertEquals(String.format("Não existe um usuario de id %d", idUsuario), response.getBody());
        Mockito.verify(usuarioRepository, Mockito.times(0)).save(Mockito.any());
    }

    @Test
    public void deveRetornarErroQuandoNaoExisteaMarca() {
        VeiculoForm usuarioForm = new VeiculoForm("marca", "modelo", "ano");
        UriComponentsBuilder uriComponentsBuilder = Mockito.mock(UriComponentsBuilder.class);
        Long idUsuario = 1L;

        Mockito.when(usuarioRepository.existsById(Mockito.any()))
                .thenReturn(true);

        Mockito.when(fipeClient.buscarMarcas())
                .thenReturn(Collections.emptyList());

        ResponseEntity response = veiculoController.salvar(uriComponentsBuilder, idUsuario, usuarioForm);

        Assert.assertEquals("Não existe uma marca com esse nome", response.getBody());
        Mockito.verify(usuarioRepository, Mockito.times(0)).save(Mockito.any());
    }

    @Test
    public void deveRetornarErroQuandoNaoExisteModelo() {
        VeiculoForm usuarioForm = new VeiculoForm("marca", "modelo", "ano");
        UriComponentsBuilder uriComponentsBuilder = Mockito.mock(UriComponentsBuilder.class);
        Long idUsuario = 1L;

        Mockito.when(usuarioRepository.existsById(Mockito.any()))
                .thenReturn(true);

        ResponseEntity response = veiculoController.salvar(uriComponentsBuilder, idUsuario, usuarioForm);

        Assert.assertEquals("Não existe uma marca com esse nome", response.getBody());
        Mockito.verify(usuarioRepository, Mockito.times(0)).save(Mockito.any());
    }
}