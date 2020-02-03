package com.api.os.service;

import com.api.os.dominios.OrdemServico;
import com.api.os.enums.StatusOS;
import com.api.os.repository.OrdemServicoRepository;
import com.api.os.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.jms.core.JmsTemplate;

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

    @Autowired
    private JmsTemplate jmsTemplate;

    // Inserir uma OS
    public OrdemServico insert(OrdemServico obj){
        obj.setId(null); // para que seja realmente nova OS
        OrdemServico ordemServico = ordemServicoRepository.save(obj);
        jmsTemplate.convertAndSend("osQueue", obj);
        return ordemServico;
    }

    // Buscar OS por id
    public OrdemServico find(Integer id){
        Optional<OrdemServico> obj = ordemServicoRepository.findById(id); // buscar objeto no banco
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id:" + id + ", Tipo: " + OrdemServico.class.getName()));
    }

    public void updateStatus (Integer id, OrdemServico os){
        OrdemServico ordemServico = find(id);
        ordemServico.setStatus(os.getStatus());
        ordemServicoRepository.save(ordemServico);
    }
}
