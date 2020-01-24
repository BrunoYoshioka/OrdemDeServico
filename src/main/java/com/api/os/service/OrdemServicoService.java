package com.api.os.service;

import com.api.os.dominios.OrdemServico;
import com.api.os.repository.OrdemServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrdemServicoService {
    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private FuncionarioService funcionarioService;

    // Inserir uma OS
    public OrdemServico insert(OrdemServico obj){
        obj.setId(null); // para que seja realmente nova OS
        obj.setDataOs(new Date()); // cria uma nova data atual do pedido
        obj.setCliente(clienteService.buscar(obj.getCliente().getId())); // usar o id para buscar do banco o cliente
        obj.setFuncionario(funcionarioService.buscar(obj.getFuncionario().getId())); // usar o id para buscar do banco o cliente
        return ordemServicoRepository.save(obj);
    }
}
