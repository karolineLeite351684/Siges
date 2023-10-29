package br.com.fiap.siges.service;

import br.com.fiap.siges.controller.exception.ControllerNotFoundException;
import br.com.fiap.siges.controller.exception.enumeration.ControllerNotFoundExceptionEnum;
import br.com.fiap.siges.dto.EstoqueDTO;
import br.com.fiap.siges.dto.file.EstoqueFileDTO;
import br.com.fiap.siges.mapper.EstoqueMapper;
import br.com.fiap.siges.mapper.file.EstoqueFileMapper;
import br.com.fiap.siges.model.Estoque;
import br.com.fiap.siges.repository.EstoqueRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository repository;

    @Autowired
    private EstoqueMapper mapper;

    @Autowired
    private EstoqueExportService exportService;

    public EstoqueDTO save(EstoqueDTO estoqueDTO) {
        Estoque estoque = mapper.toModel(estoqueDTO);
        estoque.setDataEntrada(LocalDateTime.now());
        estoque.setDataAtualizacao(LocalDateTime.now());
        return mapper.toDTO(this.repository.save(estoque));
    }

    public List<EstoqueDTO> saveAll(List<EstoqueDTO> estoqueDTOS) {
        List<Estoque> estoques = this.mapper.toListModel(estoqueDTOS);
        if (CollectionUtils.isNotEmpty(estoques)) {
            estoques.forEach(estoque -> {
                estoque.setDataEntrada(LocalDateTime.now());
                estoque.setDataAtualizacao(LocalDateTime.now());
            });
        }
        return  mapper.toListDTO(repository.saveAll(estoques));
    }

    public List<EstoqueDTO> importFile(MultipartFile file) {
        try {
            List<EstoqueDTO> productList = new ArrayList<>();

            XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
            XSSFSheet worksheet = workbook.getSheetAt(0);

            for (int index = 0; index < worksheet.getPhysicalNumberOfRows(); index++) {
                if (index > 0) {

                    XSSFRow row = worksheet.getRow(index);
                    int qtd  = (int) row.getCell(4).getNumericCellValue();

                    EstoqueDTO estoqueDTO = new EstoqueDTO(row.getCell(0).getStringCellValue(),
                            row.getCell(1).getStringCellValue(),
                            row.getCell(2).getStringCellValue(),
                            row.getCell(3).getStringCellValue(),
                                                        qtd);
                    productList.add(estoqueDTO);
                }
            }
          return this.saveAll(productList);
        } catch (IOException e) {
           throw new ControllerNotFoundException(ControllerNotFoundExceptionEnum.ESTOQUE_NAO_IMPORTADO.getMessage());
        }

    }

    public void exportToExcel(HttpServletResponse response) throws IOException {
        exportService.exportToExcel(response, repository.findAll());
    }
}