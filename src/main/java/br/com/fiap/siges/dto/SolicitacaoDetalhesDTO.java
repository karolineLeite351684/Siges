package br.com.fiap.siges.dto;

import br.com.fiap.siges.enumeration.StatusDaSolicitacaoEnum;

import java.time.LocalDate;

public record SolicitacaoDetalhesDTO(
        String idSolicitacao,
        StatusDaSolicitacaoEnum statusSolicitacao,
        String nomeDoSolicitante,
        LocalDate dataDaSolicitacao,
        Boolean ehUmNovoColaborador,
        String descricaoPedido,
        String respostaPedido
) {
}
