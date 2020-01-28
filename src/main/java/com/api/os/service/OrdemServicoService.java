package com.api.os.service;

import com.api.os.dominios.OrdemServico;
import com.api.os.enums.StatusOS;
import com.api.os.repository.OrdemServicoRepository;
import com.api.os.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

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

    // Buscar OS por id
    public OrdemServico find(Integer id){
        Optional<OrdemServico> obj = ordemServicoRepository.findById(id); // buscar objeto no banco
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id:" + id + ", Tipo: " + OrdemServico.class.getName()));
    }

    public void updateStatus (Integer id, StatusOS statusOS){
        OrdemServico ordemServico = find(id);
        ordemServico.setStatusOS(statusOS);
        ordemServicoRepository.save(ordemServico);
    }
}
