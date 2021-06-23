package com.CadastroVeiculo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<CampoComErro> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        return exception.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> new CampoComErro(fieldError.getField(), fieldError.getDefaultMessage()))
                .collect(Collectors.toList());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UsuarioNaoEncontradoException.class)
    public ApenasMensagemErro handleUsuarioNaoEncontradoException(UsuarioNaoEncontradoException exception){
        String Mensagem = exception.getMessage();
        return new ApenasMensagemErro(Mensagem);
    }
}
