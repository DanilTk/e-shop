package eshop.model;

import java.math.BigDecimal;

public class Product {

    private Long id;
    private String name;
    private Double quantity;
    private BigDecimal price;
    private MeasureName measureName;
    private ProductCategory productCategory;


    public Product(String name,
                   Double quantity,
                   BigDecimal price,
                   MeasureName measureName,
                   ProductCategory productCategory) {

        this.name = name;
        this.quantity = quantity;
        this.price = price;
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

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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
