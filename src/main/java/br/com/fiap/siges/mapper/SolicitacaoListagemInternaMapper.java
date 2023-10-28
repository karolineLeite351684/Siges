package br.com.fiap.siges.mapper;

import br.com.fiap.siges.dto.SolicitacaoListagemDTO;
import br.com.fiap.siges.dto.SolicitacaoListagemInternaDTO;
import br.com.fiap.siges.model.Solicitacao;
import org.mapstruct.Mapper;

@Mapper
public interface SolicitacaoListagemInternaMapper {

    SolicitacaoListagemInternaDTO toDTO(Solicitacao solicitacao);

}