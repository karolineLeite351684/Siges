package br.com.fiap.siges.service;

import br.com.fiap.siges.controller.exception.ControllerNotFoundException;
import br.com.fiap.siges.dto.SolicitacaoDTO;
import br.com.fiap.siges.dto.SolicitacaoDetalhesDTO;
import br.com.fiap.siges.dto.SolicitacaoListagemDTO;
import br.com.fiap.siges.enumeration.StatusDaSolicitacaoEnum;
import br.com.fiap.siges.mapper.SolicitacaoDetalhesMapper;
import br.com.fiap.siges.mapper.SolicitacaoListagemMapper;
import br.com.fiap.siges.mapper.SolicitacaoMapper;
import br.com.fiap.siges.model.Solicitacao;
import br.com.fiap.siges.repository.SolicitacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static br.com.fiap.siges.controller.exception.enumeration.ControllerNotFoundExceptionEnum.SOLICITACAO_NAO_ENCONTRADA;

@Service
public class SolicitacaoService {

    @Autowired
    private SolicitacaoRepository repository;

    @Autowired
    private SolicitacaoMapper mapper;

    @Autowired
    private SolicitacaoDetalhesMapper detalhesMapper;

    @Autowired
    private SolicitacaoListagemMapper listagemMapper;

    public SolicitacaoDTO save(SolicitacaoDTO solicitacaoDTO) {
        Solicitacao solicitacao = mapper.toModel(solicitacaoDTO);
        solicitacao.setDataDaSolicitacao(LocalDate.now());
        solicitacao.setIdSolicitacao("#" + solicitacao.getDataDaSolicitacao() + "_" + solicitacao.getNomeDoSolicitante());
        solicitacao.setStatusSolicitacao(StatusDaSolicitacaoEnum.PENDENTE);
        return mapper.toDTO(repository.save(solicitacao));
    }

    public SolicitacaoDetalhesDTO findDatalhes(Long solicitacaoID) {
        return detalhesMapper.toDTO(repository.findById(solicitacaoID).orElseThrow(() ->
                new ControllerNotFoundException(SOLICITACAO_NAO_ENCONTRADA.getMessage())));
    }

    public Page<SolicitacaoListagemDTO> findAllListagem(Pageable page) {
        return this.repository.findAll(page).map(listagemMapper::toDTO);
    }

}
