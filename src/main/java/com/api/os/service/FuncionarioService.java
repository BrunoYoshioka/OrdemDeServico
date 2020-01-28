package com.api.os.service;

import com.api.os.dominios.Funcionario;
import com.api.os.repository.FuncionarioRepository;
import com.api.os.service.exception.DataIntegrityException;
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

    public Funcionario alterar(Funcionario obj){
        Funcionario newObj = buscar(obj.getId());
        atualizaDados(newObj, obj);
        return funcionarioRepository.save(newObj);
    }

    private void atualizaDados(Funcionario newObj, Funcionario obj){
        newObj.setNome(obj.getNome());
        newObj.setCargo(obj.getCargo());
        newObj.setFone(obj.getFone());
        newObj.setPerfil(newObj.getPerfil()); // No caso quando é Enum
    }

    public void deletar(Integer id){
        Funcionario funcionario = buscar(id);
        if(funcionario.getOrdemServicos().isEmpty()){
            funcionarioRepository.deleteById(id);
        }
        else{
            throw new DataIntegrityException("Não é possível excluir porque há Ordens de Serviços");
        }
    }
}
