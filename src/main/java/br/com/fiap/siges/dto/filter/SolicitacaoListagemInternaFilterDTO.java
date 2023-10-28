package br.com.fiap.siges.dto.filter;

import br.com.fiap.siges.enumeration.StatusDaSolicitacaoEnum;

import java.time.LocalDate;

public record SolicitacaoListagemInternaFilterDTO(
        StatusDaSolicitacaoEnum statusSolicitacao,
        LocalDate dataDaSolicitacao
) {
}