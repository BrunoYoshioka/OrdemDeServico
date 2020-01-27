package com.api.os.controllers;

import com.api.os.dominios.OrdemServico;
import com.api.os.repository.OrdemServicoRepository;
import com.api.os.service.OrdemServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/os")
public class OrdemServicoController {

    @Autowired
    private OrdemServicoService ordemServicoService;

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    // Operação Inserir OS
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> inserir(@Valid @RequestBody OrdemServico obj){
        obj = ordemServicoService.insert(obj); // obj recebe um serviço onde insere a nova categoria no banco.
        // pegar o novo id e fornecer como argumento da URI
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest() // pegar URI
                .path("/{id}"/* Acrescentando id do novo recurso */).buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).build(); // gerar 201 como argumento de resposta
    }

    // Listar todos os Ordens de Serviço
    @GetMapping
    public ResponseEntity<?> listar(){
        System.out.println(LocalDateTime.now());
        List <OrdemServico> ordemServicos = ordemServicoRepository.findAll();
        return !ordemServicos.isEmpty() ? ResponseEntity.ok(ordemServicos) : ResponseEntity.noContent().build();
    }

    // Buscar OS por id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscar (@PathVariable Integer id){
        OrdemServico obj = ordemServicoService.find(id);
        return ResponseEntity.ok().body(obj);
    }
}
