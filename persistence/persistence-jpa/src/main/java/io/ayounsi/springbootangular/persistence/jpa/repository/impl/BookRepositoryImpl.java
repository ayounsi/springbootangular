package io.ayounsi.springbootangular.persistence.jpa.repository.impl;

import io.ayounsi.springbootangular.domain.books.Book;
import io.ayounsi.springbootangular.domain.books.BookRepository;
import io.ayounsi.springbootangular.persistence.jpa.core.AbstractCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
class BookRepositoryImpl extends AbstractCrudRepository<Book, Long, BookJpaRepository> implements BookRepository {

    private final BookJdbcRepository jdbcRepository;

    public BookRepositoryImpl(BookJpaRepository jpaRepository, BookJdbcRepository jdbcRepository) {
        super(jpaRepository);
        this.jdbcRepository = jdbcRepository;
    }

    @Override
    public int[][] batchInsert(List<Book> books) {
        return jdbcRepository.batchInsert(books);
    }
}
