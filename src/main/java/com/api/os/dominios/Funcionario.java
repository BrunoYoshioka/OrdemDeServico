package com.api.os.dominios;

import com.api.os.enums.Perfil;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
@Getter @Setter
@Entity
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
    private String cargo;

    @Enumerated(EnumType.STRING)
    private Perfil perfil;
}
