package br.com.fiap.siges.controller;

import br.com.fiap.siges.dto.EstoqueDTO;
import br.com.fiap.siges.dto.file.EstoqueFileDTO;
import br.com.fiap.siges.service.EstoqueService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/estoques")
public class EstoqueController {

    @Autowired
    private EstoqueService service;

    @PostMapping
    public ResponseEntity<EstoqueDTO> save(@RequestBody EstoqueDTO estoqueDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(estoqueDTO));
    }

    @PostMapping(value = "/import")
    public ResponseEntity<List<EstoqueFileDTO>> importFile(@RequestParam("file") MultipartFile file) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.importFile(file));
    }

    @GetMapping(value = "/export", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public void exportToExcel(HttpServletResponse response) throws IOException {
        this.service.exportToExcel(response);
    }
}