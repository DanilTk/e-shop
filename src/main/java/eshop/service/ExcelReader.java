package eshop.service;

import eshop.model.Client;

import java.util.List;

public interface ExcelReader {

    List<Client> retrieveClients();

    List<Client> exportClients();
}