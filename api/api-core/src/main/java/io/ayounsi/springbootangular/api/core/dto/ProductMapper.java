package io.ayounsi.springbootangular.api.core.dto;

import io.ayounsi.springbootangular.domain.products.Product;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper {

    ProductDto fromProduct(Product product);
}
