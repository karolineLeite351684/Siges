package br.com.fiap.siges.controller.exception.enumeration;

import lombok.Getter;

@Getter
public enum ControllerNotFoundExceptionEnum {

    SOLICITACAO_NAO_ENCONTRADA("Solicitação não encontrada");

    private final String message;

    ControllerNotFoundExceptionEnum(String message) {
        this.message = message;
    }
}
