package io.ayounsi.springbootangular.persistence.reactive.repository.impl;

import io.ayounsi.springbootangular.domain.books.Book;
import io.ayounsi.springbootangular.domain.core.repository.ReactiveRepository;
import io.ayounsi.springbootangular.persistence.reactive.commons.AbstractReactiveRepository;
import org.springframework.stereotype.Repository;

@Repository
class BookRepositoryImpl extends AbstractReactiveRepository<Book, Long, BookReactiveRepository> implements ReactiveRepository<Book, Long> {

    public BookRepositoryImpl(BookReactiveRepository reactiveRepository) {
        super(reactiveRepository);
    }

}
