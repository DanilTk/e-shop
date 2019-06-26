package eshop.service;

import eshop.model.Client;

import java.io.IOException;
import java.util.List;

public interface ExcelReader {

    List<Client> importDataFromExcel(String excelPath) throws IOException;

    List<Client> exportDataToExcel(String savingPath);
}