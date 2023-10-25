package br.com.fiap.siges.dto;

import br.com.fiap.siges.enumeration.StatusDaSolicitacaoEnum;

import java.time.LocalDate;

public record SolicitacaoDTO(

        Long id,
        String idSolicitacao,
        StatusDaSolicitacaoEnum statusSolicitacao,
        String nomeDoSolicitante,
        LocalDate dataDaSolicitacao,
        Boolean ehUmNovoColaborador,
        String infomacaoDaSolicitacao
) {
}
