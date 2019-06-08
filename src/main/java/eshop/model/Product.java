package eshop.model;

import java.math.BigDecimal;

enum MeasureName {

    KILOGRAM,
    GRAMM,
    PIECE
}

enum ProductCategory {

    TEA,
    COFFEE,
    ELECTRONICS
}

public class Product {

    private Long id;
    private String name;
    private BigDecimal price;
    private Double quantity;
    private MeasureName measureName;
    private ProductCategory productCategory;

    public Product(String name,
                   BigDecimal price,
                   Double quantity,
                   MeasureName measureName,
                   ProductCategory productCategory) {

        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.measureName = measureName;
        this.productCategory = productCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public MeasureName getMeasureName() {
        return measureName;
    }

    public void setMeasureName(MeasureName measureName) {
        this.measureName = measureName;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }
}