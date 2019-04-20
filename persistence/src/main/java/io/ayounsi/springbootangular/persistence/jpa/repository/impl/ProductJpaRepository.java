package io.ayounsi.springbootangular.persistence.jpa.repository.impl;

import io.ayounsi.springbootangular.domain.products.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository<Product, Long> {
}
