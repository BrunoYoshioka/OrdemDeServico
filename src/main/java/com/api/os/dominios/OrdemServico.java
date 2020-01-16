package com.api.os.dominios;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class OrdemServico implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer os;

    @NotNull
    private Date dataOs;

    private String tipoServico;

    @NotNull
    private String situacaoAp;

    @NotNull
    private String equipamento;

    @NotNull
    private String defeito;

    @NotNull
    private Double valor;

    @ManyToOne @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @NotNull
    private String serie;

    @ManyToOne @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    public OrdemServico(){}

}
