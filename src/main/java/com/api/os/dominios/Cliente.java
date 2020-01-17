package com.api.os.dominios;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@EqualsAndHashCode
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull @Size(min = 5, max = 30)
    private String nome;

    @NotNull
    private String cpf;

    @NotNull
    private String fone;

    private String email;
}
