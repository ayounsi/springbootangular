package io.ayounsi.springbootangular.domain.products;

import io.ayounsi.springbootangular.domain.commons.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A product is the item offered for sale. A product can be a service or an item.
 * It can be physical or in virtual or cyber form. Every product is made at a cost and each is sold at a price
 */
@Entity
@Table(name = "products")
public class Product extends BaseEntity {

    private String businessKey;
    private String name;
    private String description;
    private BigDecimal price;

    public Product(String businessKey, String name, String description, BigDecimal price) {
        this.businessKey = businessKey;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    protected Product() {
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Product product = (Product) o;
        return businessKey.equals(product.businessKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), businessKey);
    }

    @Override
    public String toString() {
        return "Product{" +
                "businessKey='" + businessKey + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

}
