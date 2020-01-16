package com.api.os.controllers;

import com.api.os.dominios.Cliente;
import com.api.os.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    public ResponseEntity<Cliente> listar(@PathVariable Integer id){
//        Cliente obj = service
        return null;
    }
}
