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

    @Autowired
    private ClienteService clienteService;

    //mostrar todos os clientes
    @GetMapping
    public ResponseEntity<?> Listar(){
        List <Cliente> clientes = clienteRepository.findAll();
        return !clientes.isEmpty() ? ResponseEntity.ok(clientes) : ResponseEntity.noContent().build();
    }

    //pesquisar clientes por id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> listar(@PathVariable Integer id){
        Cliente obj = clienteService.buscar(id);
        return ResponseEntity.ok().body(obj);
    }
}
