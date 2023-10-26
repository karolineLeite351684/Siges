package br.com.fiap.siges.mapper;

import br.com.fiap.siges.dto.SolicitacaoDTO;
import br.com.fiap.siges.dto.SolicitacaoDetalhesDTO;
import br.com.fiap.siges.model.Solicitacao;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface SolicitacaoDetalhesMapper {

    SolicitacaoDetalhesDTO toDTO(Solicitacao solicitacao);
}
