package br.com.fiap.siges.mapper;

import br.com.fiap.siges.dto.SolicitacaoDTO;
import br.com.fiap.siges.model.Solicitacao;
import org.mapstruct.Mapper;

@Mapper
public interface SolicitacaoMapper {

    SolicitacaoDTO toDTO(Solicitacao solicitacao);

    Solicitacao toModel(SolicitacaoDTO solicitacaoDTO);
}
