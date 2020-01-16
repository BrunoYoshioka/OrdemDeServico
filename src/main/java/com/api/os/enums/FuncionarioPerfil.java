package com.api.os.enums;

import lombok.Getter;

import java.io.Serializable;

public enum FuncionarioPerfil {

    A("ADMINISTRADOR"),
    C("USUÁRIO COMUM");

    FuncionarioPerfil(String descricao){
        this.descricao = descricao;
    }

    @Getter
    private String descricao;
}