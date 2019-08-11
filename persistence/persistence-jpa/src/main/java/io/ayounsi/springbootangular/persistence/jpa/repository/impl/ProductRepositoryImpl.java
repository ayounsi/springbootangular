package io.ayounsi.springbootangular.persistence.jpa.repository.impl;

import io.ayounsi.springbootangular.domain.products.Product;
import io.ayounsi.springbootangular.domain.products.ProductRepository;
import io.ayounsi.springbootangular.persistence.jpa.core.AbstractCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImpl extends AbstractCrudRepository<Product, Long, ProductJpaRepository> implements ProductRepository {
    public ProductRepositoryImpl(ProductJpaRepository jpaRepository) {
        super(jpaRepository);
    }
}
