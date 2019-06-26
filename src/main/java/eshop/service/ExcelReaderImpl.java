package eshop.service;

import eshop.model.Client;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReaderImpl implements ExcelReader {

    //TODO: Update method to handle generics and predicate to be able to parse both products and clients

    @Override
    public List<Client> importDataFromExcel(String excelPath) throws IOException {

        Workbook workbook = WorkbookFactory.create(new File(excelPath));
        List<Client> clients = new ArrayList<>();
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.rowIterator();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            if (row.getRowNum() == 0) continue;

            Client client = extractClientFromExcelRow(row);
            clients.add(client);
        }
        return clients;
    }

    @Override
    public List<Client> exportDataToExcel(String savingPath) {
        return null;
    }

    private Client extractClientFromExcelRow(Row row) {

        Long id = Long.parseLong(row.getCell(0).getStringCellValue());
        if (row.getCell(0).getStringCellValue().isEmpty()) {
            id = null;
        }

        String name = row.getCell(1).getStringCellValue();
        if (row.getCell(1).getStringCellValue().isEmpty()) {
            name = null;
        }

        String surname = row.getCell(2).getStringCellValue();
        if (row.getCell(2).getStringCellValue().isEmpty()) {
            surname = null;
        }
        return new Client(id, name, surname);
    }
}