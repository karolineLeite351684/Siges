package br.com.fiap.siges.service;

import br.com.fiap.siges.dto.SolicitacaoDTO;
import br.com.fiap.siges.enumeration.StatusDaSolicitacaoEnum;
import br.com.fiap.siges.mapper.SolicitacaoMapper;
import br.com.fiap.siges.model.Solicitacao;
import br.com.fiap.siges.repository.SolicitacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class SolicitacaoService {

    @Autowired
    private SolicitacaoRepository repository;

    @Autowired
    private SolicitacaoMapper mapper;

    public SolicitacaoDTO save(SolicitacaoDTO solicitacaoDTO) {
        Solicitacao solicitacao = mapper.toModel(solicitacaoDTO);
        solicitacao.setDataDaSolicitacao(LocalDate.now());
        solicitacao.setIdSolicitacao("#" + solicitacao.getDataDaSolicitacao() + "_" + solicitacao.getNomeDoSolicitante());
        solicitacao.setStatusSolicitacao(StatusDaSolicitacaoEnum.PENDENTE);
        return mapper.toDTO(repository.save(solicitacao));
    }
}
