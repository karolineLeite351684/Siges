package br.com.fiap.siges.controller;

import br.com.fiap.siges.dto.SolicitacaoDTO;
import br.com.fiap.siges.dto.SolicitacaoDetalhesDTO;
import br.com.fiap.siges.dto.SolicitacaoListagemDTO;
import br.com.fiap.siges.service.SolicitacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/solicitacoes")
public class SolicitacaoController {

    @Autowired
    private SolicitacaoService service;

    @PostMapping
    public ResponseEntity<SolicitacaoDTO> save(@RequestBody SolicitacaoDTO solicitacaoDTO) {
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(service.save(solicitacaoDTO));
    }

    @GetMapping("/{id}/detalhes")
    public ResponseEntity<SolicitacaoDetalhesDTO> findDetalhesFindById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findDatalhes(id));
    }

    @GetMapping("/listagem")
    public ResponseEntity<Page<SolicitacaoListagemDTO>> findAllListagem(
            @PageableDefault(size = 30, page = 0, sort = "dataDaSolicitacao") Pageable page) {
        return ResponseEntity.ok(service.findAllListagem(page));
    }


}
