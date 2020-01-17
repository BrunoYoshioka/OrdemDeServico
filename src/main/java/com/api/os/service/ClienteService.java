package com.api.os.service;

import com.api.os.dominios.Cliente;
import com.api.os.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Service // lógica de negócio
public class ClienteService {

    //@Autowired
    //private ClienteRepository clienteRepository;

/*    //serviço para buscar todos os clientes ( caso usar DTO )
    public List<Cliente> buscarTodos(){
        return clienteRepository.findAll();
    }*/

    //buscar todos os clientes com paginação


    //buscar por id
//    public Cliente find(Integer id){
//        Optional<Cliente> obj = clienteRepository.findAll();
//        return null;
//    }
}
