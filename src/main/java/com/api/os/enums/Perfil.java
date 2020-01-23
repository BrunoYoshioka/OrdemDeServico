package com.api.os.enums;

import lombok.Getter;

public enum Perfil {

    ADMIN("ADMINISTRADOR"),
    USER("USUÁRIO COMUM");

    Perfil(String descricao){
        this.descricao = descricao;
    }

    @Getter
    private String descricao;
}