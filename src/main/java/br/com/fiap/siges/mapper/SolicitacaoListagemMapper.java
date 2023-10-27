package br.com.fiap.siges.mapper;

import br.com.fiap.siges.dto.SolicitacaoListagemDTO;
import br.com.fiap.siges.model.Solicitacao;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;
@Mapper
public interface SolicitacaoListagemMapper {

    SolicitacaoListagemDTO toDTO(Solicitacao solicitacao);

}
