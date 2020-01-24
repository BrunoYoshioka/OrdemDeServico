package com.api.os.controllers;

import com.api.os.dominios.OrdemServico;
import com.api.os.service.OrdemServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/os")
public class OrdemServicoController {

    @Autowired
    private OrdemServicoService ordemServicoService;

    // Operação Inserir OS
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> inserir(@Valid @RequestBody OrdemServico obj){
        obj = ordemServicoService.insert(obj); // obj recebe um serviço onde insere a nova categoria no banco.
        // pegar o novo id e fornecer como argumento da URI
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest() // pegar URI
                .path("/{id}"/* Acrescentando id do novo recurso */).buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).build(); // gerar 201 como argumento de resposta
    }
}
