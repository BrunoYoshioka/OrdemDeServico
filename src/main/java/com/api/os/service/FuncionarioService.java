package com.api.os.service;

import com.api.os.dominios.Funcionario;
import com.api.os.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Funcionario inserir(Funcionario obj){
        obj.setId(null);
        return funcionarioRepository.save(obj);
    }
}
