package br.com.fiap.siges.service;

import br.com.fiap.siges.dto.EstoqueDTO;
import br.com.fiap.siges.mapper.EstoqueMapper;
import br.com.fiap.siges.model.Estoque;
import br.com.fiap.siges.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository repository;

    @Autowired
    private EstoqueMapper mapper;

    public EstoqueDTO save(EstoqueDTO estoqueDTO) {
        Estoque estoque = mapper.toModel(estoqueDTO);
        estoque.setDataEntrada(LocalDateTime.now());
        estoque.setDataAtualizacao(LocalDateTime.now());
        return mapper.toDTO(this.repository.save(estoque));
    }
}