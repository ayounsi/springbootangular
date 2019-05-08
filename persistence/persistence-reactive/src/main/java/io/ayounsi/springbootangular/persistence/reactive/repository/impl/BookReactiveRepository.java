package io.ayounsi.springbootangular.persistence.reactive.repository.impl;

import io.ayounsi.springbootangular.domain.books.Book;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

interface BookReactiveRepository extends ReactiveCrudRepository<Book, Long> {
}
