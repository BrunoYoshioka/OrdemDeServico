package com.api.os.controllers;

import com.api.os.dominios.Funcionario;
import com.api.os.repository.FuncionarioRepository;
import com.api.os.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody Funcionario obj){
        obj = funcionarioService.inserir(obj);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<?> Listar(){
        List<Funcionario> funcionarios = funcionarioRepository.findAll();
        return !funcionarios.isEmpty() ? ResponseEntity.ok(funcionarios) : ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> listar(@PathVariable Integer id){
        Funcionario obj = funcionarioService.buscar(id);
        return ResponseEntity.ok().body(obj);
    }

    // Alterar Funcionario
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> alterar(@Valid @RequestBody Funcionario obj, @PathVariable Integer id){
        obj.setId(id);
        obj = funcionarioService.alterar(obj);
        return ResponseEntity.noContent().build();
    }
}
