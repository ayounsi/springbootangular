package io.ayounsi.springbootangular.api.core.dto;

import io.ayounsi.springbootangular.domain.products.Product;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProductDto implements Serializable {

    public Long id;
    public String businessKey;
    public String name;
    public BigDecimal price;
    public String description;

    protected ProductDto() {
    }

    public ProductDto(Long id, String businessKey, String name, BigDecimal price, String description) {
        this.id = id;
        this.businessKey = businessKey;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public static ProductDto fromProduct(Product product) {
        return new ProductDto(
                product.getId(),
                product.getBusinessKey(),
                product.getName(),
                product.getPrice(),
                product.getDescription());
    }

}
