package com.api.os.service.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.api.os.controllers.exception.FieldMessage;
import com.api.os.dominios.Cliente;
import com.api.os.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ClienteInsertValidator implements ConstraintValidator</*Especificar o tipo de anotação*/ClienteAnnotation, /*Tipo da classe que aceita a anotação*/Cliente> {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public void initialize(ClienteAnnotation ann) {
    }

    @Override
    public boolean isValid(Cliente obj, ConstraintValidatorContext context) {

        List<FieldMessage> list = new ArrayList<>(); // criei uma lista vazia de FieldMessage

//        Cliente aux = clienteRepository.findByEmail(obj.getEmail());
//        if(aux != null Registro Encontrado no banco) {
//            list.add(new FieldMessage("email", "Email já existente")); // gerei erro de validação
//        }

        // Teste se não for válido o CPF
        if(!ValidaCPF.isValidCPF(obj.getCpf())) {
            list.add(new FieldMessage("cpf", "CPF inválido"));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return list.isEmpty(); // se a minha lista de erros tiver vazia, significa que não teve nenhum erro, então o método IsValid retorna verdadeiro,
        // porem se houver erro, a lista não estará vazia e o método retorna falso
    }
}
