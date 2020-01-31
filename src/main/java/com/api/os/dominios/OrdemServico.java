package com.api.os.dominios;

import com.api.os.enums.StatusOS;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
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

    //@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataOs = LocalDateTime.now();

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

    @NotNull(message = "Preenchimento Obrigatório")
    @Enumerated(EnumType.STRING)
    private StatusOS status;

    public OrdemServico(){}

}
