package com.CadastroVeiculo.veiculo;

import com.CadastroVeiculo.client.*;
import com.CadastroVeiculo.exception.ApenasMensagemErro;
import com.CadastroVeiculo.exception.UsuarioNaoEncontradoException;
import com.CadastroVeiculo.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios/{idUsuario}/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoRepository veiculoRepository;
    @Autowired
    private FipeClient fipeClient;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity salvar(UriComponentsBuilder uriComponentsBuilder,
                                 @PathVariable Long idUsuario,
                                 @RequestBody VeiculoForm veiculoForm) {
        boolean existeUsuario = usuarioRepository.existsById(idUsuario);

        if (!existeUsuario) {
            throw new UsuarioNaoEncontradoException(String
                    .format("Não foi encontrado um usuario com id %d, por favor utilize um usuário cadastrado", idUsuario));
        }

        List<BuscaMarcaResponse> buscaMarcaResponse = fipeClient.buscarMarcas();
        Optional<BuscaMarcaResponse> possivelMarca = buscaMarcaResponse.stream()
                .filter(elemento -> elemento.getNome().equals(veiculoForm.getMarca()))
                .findFirst();

        if (possivelMarca.isEmpty()) {
            return ResponseEntity.badRequest()
                    .body(new ApenasMensagemErro("Não existe uma marca com esse nome"));
        }

        BuscaMarcaResponse marca = possivelMarca.get();

        BuscaModeloResponseWrapper buscarModeloResponse = fipeClient.buscarModelos(marca.getCodigo());
        Optional<String> possivelModelo = buscarModeloResponse.buscarCodigoDoModelo(veiculoForm.getModelo());

        if (possivelModelo.isEmpty()) {
            return ResponseEntity.badRequest().body(new ApenasMensagemErro(String
                    .format("Não existe um modelo com esse nome para a Marca: %s",
                    veiculoForm.getMarca())));
        }

        List<BuscaAnoResponse> buscaAnoResponse = fipeClient.buscarAnos(marca.getCodigo(), possivelModelo.get());
        Optional<String> possivelAno = buscaAnoResponse.stream()
                .filter(ano -> ano.getNome().equals(veiculoForm.getAno()))
                .map(BuscaAnoResponse::getCodigo)
                .findFirst();


        if (possivelAno.isEmpty()) {
            return ResponseEntity.badRequest().body(new ApenasMensagemErro(String
                    .format("Não existe um carro com esse ano para a Marca: %s e o Modelo: %s",
                    veiculoForm.getMarca(),
                    veiculoForm.getModelo())));
        }

        BuscaValorResponse carro = fipeClient.buscarValor(marca.getCodigo(), possivelModelo.get(), possivelAno.get());

        Veiculo veiculo = veiculoForm.transformarEmVeiculo(carro.getValor(), idUsuario,carro.getAnoModelo());
        Veiculo veiculoSalvo = veiculoRepository.save(veiculo);

        URI uriRecurso = uriComponentsBuilder
                .path("/usuarios/{idUsuario}/veiculos/{idVeiculo}")
                .build(idUsuario, veiculoSalvo.getIdUsuario());
        return ResponseEntity.created(uriRecurso).body(new VeiculoDTO(veiculoSalvo));
    }
}
