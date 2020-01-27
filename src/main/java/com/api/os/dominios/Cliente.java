package com.api.os.dominios;

import com.api.os.service.validation.ClienteAnnotation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@EqualsAndHashCode
@ClienteAnnotation
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Preenchimento Obrigatório")
    @Size(min = 5, max = 50, message = "O tamanho de caracteres deve ser de 5 a 50")
    private String nome;

    @NotEmpty(message = "Preenchimento Obrigatório")
    private String cpf;

    @NotEmpty(message = "Preenchimento Obrigatório")
    private String fone;

    @Email(message = "Email inválido")
    private String email;

    @JsonIgnore // As Ordems de Serviços do cliente não serão serializados
    @OneToMany(mappedBy = "cliente")
    private List<OrdemServico> ordemServicos = new ArrayList<>();

}
