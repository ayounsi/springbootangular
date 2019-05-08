package io.ayounsi.springbootangular.persistence.reactive.repository.impl;

import io.ayounsi.springbootangular.domain.commons.model.ReactiveRepository;
import io.ayounsi.springbootangular.domain.products.Product;
import io.ayounsi.springbootangular.persistence.reactive.commons.AbstractReactiveRepository;
import org.springframework.stereotype.Repository;

@Repository
class ProductRepositoryReactiveImpl extends AbstractReactiveRepository<Product, Long, ProductReactiveRepository> implements ReactiveRepository<Product, Long> {

    public ProductRepositoryReactiveImpl(ProductReactiveRepository reactiveRepository) {
        super(reactiveRepository);
    }

}
