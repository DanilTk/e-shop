package eshop.model;

import java.util.LinkedList;
import java.util.List;

public class Basket {

    private Long id;
    private Client client;
    private List<Product> products;

    public Basket(Client client) {
        this.client = client;
        this.products = new LinkedList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public List<Product> getProducts() {
        return products;
    }
}