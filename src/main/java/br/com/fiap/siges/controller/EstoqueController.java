package br.com.fiap.siges.controller;

import br.com.fiap.siges.dto.EstoqueDTO;
import br.com.fiap.siges.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estoques")
public class EstoqueController {

    @Autowired
    private EstoqueService service;

    @PostMapping
    public ResponseEntity<EstoqueDTO> save(@RequestBody EstoqueDTO estoqueDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(estoqueDTO));
    }
}