package com.api.os.service;

import com.api.os.dominios.Funcionario;
import com.api.os.repository.FuncionarioRepository;
import com.api.os.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Funcionario inserir(Funcionario obj){
        obj.setId(null);
        return funcionarioRepository.save(obj);
    }

    public Funcionario buscar(Integer id){
        Optional<Funcionario> obj = funcionarioRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + "Tipo: " + Funcionario.class.getName()
        ));
    }
}
