package br.com.fiap.siges.mapper;

import br.com.fiap.siges.dto.EstoqueDTO;
import br.com.fiap.siges.model.Estoque;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface EstoqueMapper {
    EstoqueDTO toDTO(Estoque estoque);

    Estoque toModel(EstoqueDTO estoqueDTO);

}