package com.CadastroVeiculo;

import com.CadastroVeiculo.usuario.UsuarioForm;
import com.CadastroVeiculo.veiculo.VeiculoController;
import com.CadastroVeiculo.veiculo.VeiculoRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.util.UriComponentsBuilder;

@RunWith(MockitoJUnitRunner.class)
class CadastroVeiculoApplicationTests {

	@Mock
	private VeiculoRepository veiculoRepository;

	@Autowired
	@InjectMocks
	private VeiculoController veiculoController;

	@Test
	public void deveRetornarErroQuandoUsuarioNaoExiste() {
		UsuarioForm usuarioForm = new UsuarioForm("nome", "email", "cpf");
		UriComponentsBuilder uriComponentsBuilder = Mockito.mock(UriComponentsBuilder.class);


	}

}
