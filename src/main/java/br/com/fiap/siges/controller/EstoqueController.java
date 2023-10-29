package br.com.fiap.siges.controller;

import br.com.fiap.siges.dto.EstoqueDTO;
import br.com.fiap.siges.service.EstoqueService;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
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
    public ResponseEntity<List<EstoqueDTO>> importExcelFile(@RequestParam("file") MultipartFile file) throws IOException {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.importFile(file));
    }
}