package br.com.fiap.siges.controller;

import br.com.fiap.siges.dto.SolicitacaoDTO;
import br.com.fiap.siges.service.SolicitacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/solicitacoes")
public class SolicitacaoController {

    @Autowired
    private SolicitacaoService service;

    @PostMapping
    private ResponseEntity<SolicitacaoDTO> save(@RequestBody SolicitacaoDTO solicitacaoDTO) {
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(service.save(solicitacaoDTO));
    }
}
