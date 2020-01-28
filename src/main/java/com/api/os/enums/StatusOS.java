package com.api.os.enums;

import lombok.Getter;
import lombok.Setter;

public enum StatusOS {
    ANDAMENTO(1, "EM ANDAMENTO"),
    FINALIZADO(2, "FINALIZADO"),
    CANCELADO(3, "CANCELADO");

    StatusOS(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    @Getter @Setter
    private Integer id;

    @Getter @Setter
    private String descricao;
}
