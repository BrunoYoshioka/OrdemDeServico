package com.api.os.service;

import com.api.os.dominios.Cliente;
import com.api.os.repository.ClienteRepository;
import com.api.os.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service // lógica de negócio
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

/*    //serviço para buscar todos os clientes ( caso usar DTO )
    public List<Cliente> buscarTodos(){
        return clienteRepository.findAll();
    }*/

    //buscar todos os clientes com paginação

    //buscar por id (recurso do java 8)
    public Cliente buscar(Integer id) {
        Optional<Cliente> obj = clienteRepository.findById(id); // busca o objeto no banco
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName())); // caso não existir
    }

    // serviço para cadastrar clientes
    public Cliente inserir(Cliente obj){
        obj.setId(null); // objeto novo a ser inserido, tem que ser nulo
        return clienteRepository.save(obj); // método salvar
    }
}
