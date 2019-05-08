package io.ayounsi.springbootangular.persistence.jpa.repository.impl;

import io.ayounsi.springbootangular.domain.books.Book;
import org.springframework.data.jpa.repository.JpaRepository;

interface BookJpaRepository extends JpaRepository<Book, Long> {
}
