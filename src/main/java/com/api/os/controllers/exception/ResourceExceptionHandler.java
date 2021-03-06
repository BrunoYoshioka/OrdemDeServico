package com.api.os.controllers.exception;

import javax.servlet.http.HttpServletRequest;

import com.api.os.service.exception.DataIntegrityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.api.os.service.exception.ObjectNotFoundException;

// Classe auxiliar para interceptar as excessões

@ControllerAdvice
public class ResourceExceptionHandler {
    // e obrigatoriamente dentro do framework deverá ter assinatura abaixo
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound (ObjectNotFoundException e, HttpServletRequest request){

        StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(DataIntegrityException.class) // indicar o tratamento de excessões
    public ResponseEntity<StandardError> dataIntegrity (DataIntegrityException e, HttpServletRequest request){

        StandardError err = new StandardError(HttpStatus.BAD_REQUEST.value(),
                e.getMessage(), // mensagem de excessão
                System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class) // indicar o tratamento de excessões
    public ResponseEntity<StandardError> validation (MethodArgumentNotValidException e, HttpServletRequest request){

        ValidationError err = new ValidationError(HttpStatus.BAD_REQUEST.value(),
                // e.getMessage(), // mensagem de excessão
                "Erro de validação", // trocar por esse erro de mensagem
                System.currentTimeMillis());

        // percorrendo a lista de errors, ja tem a excessão do framework somente o nome do campo e a mensagem correspondente ao erro
        // para cada FieldError gero o objeto FieldMessage
        for(FieldError x: e.getBindingResult().getFieldErrors()) {
            err.addError(x.getField(), x.getDefaultMessage());
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }
}
