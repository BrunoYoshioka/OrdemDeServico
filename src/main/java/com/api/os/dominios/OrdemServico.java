package com.api.os.dominios;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@EqualsAndHashCode
public class OrdemServico implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Preenchimento Obrigatório")
    private String serie;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date dataOs;

    @ManyToOne @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @NotNull(message = "Preenchimento Obrigatório")
    private String tipoServico;

    @NotNull(message = "Preenchimento Obrigatório")
    private String situacaoAp;

    @NotNull(message = "Preenchimento Obrigatório")
    private String equipamento;

    @NotNull(message = "Preenchimento Obrigatório")
    private String defeito;

    @ManyToOne @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    @NotNull(message = "Preenchimento Obrigatório")
    private Double valor;

    public OrdemServico(){}

}
