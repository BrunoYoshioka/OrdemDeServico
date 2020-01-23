package com.api.os.controllers;

import com.api.os.dominios.Cliente;
import com.api.os.repository.ClienteRepository;
import com.api.os.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteService clienteService;

    private final long segundo = 1000;

    //mostrar todos os clientes
    @GetMapping
    @Scheduled(fixedDelay = segundo)
    public ResponseEntity<?> Listar(){
        System.out.println(LocalDateTime.now());
        List <Cliente> clientes = clienteRepository.findAll();
        return !clientes.isEmpty() ? ResponseEntity.ok(clientes) : ResponseEntity.noContent().build();
    }

    //pesquisar clientes por id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> listar(@PathVariable Integer id){
        Cliente obj = clienteService.buscar(id);
        return ResponseEntity.ok().body(obj);
    }

    //operação de inserir clientes
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void>insert(@Valid @RequestBody Cliente obj){
        obj = clienteService.inserir(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    //Alterar cliente
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> alterar(@Valid @RequestBody Cliente obj, @PathVariable Integer id){
        obj.setId(id);
        obj = clienteService.alterar(obj);
        return ResponseEntity.noContent().build();
    }

    //Deletar Cliente
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletar(@PathVariable Integer id){
        clienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
