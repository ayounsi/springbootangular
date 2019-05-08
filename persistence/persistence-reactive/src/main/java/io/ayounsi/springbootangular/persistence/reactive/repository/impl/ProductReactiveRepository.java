package io.ayounsi.springbootangular.persistence.reactive.repository.impl;

import io.ayounsi.springbootangular.domain.products.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

interface ProductReactiveRepository extends ReactiveCrudRepository<Product, Long> {
}
