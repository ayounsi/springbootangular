package io.ayounsi.springbootangular.persistence.jpa.repository.impl;

import io.ayounsi.springbootangular.domain.books.Book;
import io.ayounsi.springbootangular.domain.books.BookRepository;
import io.ayounsi.springbootangular.persistence.jpa.commons.AbstractCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
class BookRepositoryImpl extends AbstractCrudRepository<Book, Long, BookJpaRepository> implements BookRepository {

    public BookRepositoryImpl(BookJpaRepository jpaRepository) {
        super(jpaRepository);
    }
}
