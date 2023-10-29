package br.com.fiap.siges.service;

import br.com.fiap.siges.model.Estoque;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class EstoqueExportService extends ReportAbstractService {

    public void writeTableData(Object data) {
        // data
        List<Estoque> list = (List<Estoque>) data;

        // font style content
        CellStyle style = getFontContentExcel();

        // starting write on row
        int startRow = 2;

        // write content
        for (Estoque estoque : list) {
            Row row = sheet.createRow(startRow++);
            int columnCount = 0;
            createCell(row, columnCount++, estoque.getId(), style);
            createCell(row, columnCount++, estoque.getTipo(), style);
            createCell(row, columnCount++, estoque.getMarca(), style);
            createCell(row, columnCount++, estoque.getNome(), style);
            createCell(row, columnCount++, estoque.getIdentificador(), style);
            createCell(row, columnCount++, estoque.getQuantidade(), style);
            createCell(row, columnCount++, estoque.getDataEntrada(), style);
            createCell(row, columnCount++, estoque.getDataAtualizacao(), style);
        }
    }


    public void exportToExcel(HttpServletResponse response, Object data) throws IOException {
        newReportExcel();

        // response  writer to excel
        response = initResponseForExportExcel(response, "Estoque");
        ServletOutputStream outputStream = response.getOutputStream();


        // write sheet, title & header
        String[] headers = new String[]{"id", "tipo", "marca", "nome", "identificador", "quantidade", "dataEntrada", "dataAtualizacao"};
        writeTableHeaderExcel("Estoque", "CONTROLE DE ESTOQUE", headers);
        // write content row
        writeTableData(data);

        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}
