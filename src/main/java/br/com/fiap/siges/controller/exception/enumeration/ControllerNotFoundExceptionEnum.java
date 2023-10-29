package br.com.fiap.siges.controller.exception.enumeration;

import lombok.Getter;

@Getter
public enum ControllerNotFoundExceptionEnum {

    SOLICITACAO_NAO_ENCONTRADA("Solicitação não encontrada"),

    ESTOQUE_NAO_IMPORTADO("O estoque não foi importado");

    private final String message;

    ControllerNotFoundExceptionEnum(String message) {
        this.message = message;
    }
}
