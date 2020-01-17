package com.api.os.controllers;

import com.api.os.dominios.Cliente;
import com.api.os.repository.ClienteRepository;
import com.api.os.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    //mostrar todos os clientes
    @GetMapping
    public ResponseEntity<?> Listar(){
        List <Cliente> clientes = clienteRepository.findAll();
        return !clientes.isEmpty() ? ResponseEntity.ok(clientes) : ResponseEntity.noContent().build();
    }
}
