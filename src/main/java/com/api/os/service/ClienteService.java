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

    // alterar cliente
    public Cliente alterar(Cliente obj){
        Cliente newObj = buscar(obj.getId()); // Instanciar cliente a partir do banco de dados e reaproveitar do método buscar
        atualizaDados(newObj,obj);
        return clienteRepository.save(newObj); // salva o newObj
    }

    // será tipo private pq ele é metodo auxiliar de dentro da classe, pois não tem motivo de ficar exposto pra fora
    private void atualizaDados(Cliente newObj, Cliente obj){
        // Essa variavel newObj que busquei todos os dados do banco irá atualizar para os novos valores fornecidos no obj
        newObj.setNome(obj.getNome());
        newObj.setCpf(obj.getCpf());
        newObj.setFone(obj.getFone());
        newObj.setEmail(obj.getEmail());
    }
}
