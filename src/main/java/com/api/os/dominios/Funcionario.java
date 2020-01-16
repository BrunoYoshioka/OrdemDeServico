package com.api.os.dominios;

import com.api.os.enums.FuncionarioPerfil;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull @Size(min = 5, max = 30)
    private String nome;

    @NotNull
    private String fone;

    @NotNull
    private String login;

    @NotNull
    private String cargo;

    @NotNull
    private String senha;

    @NotNull
    private String perfil;

    @Enumerated(EnumType.STRING)
    private FuncionarioPerfil funcionarioPerfil;

    public Funcionario(){}

}
