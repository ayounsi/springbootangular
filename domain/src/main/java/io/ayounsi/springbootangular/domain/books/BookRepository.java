package io.ayounsi.springbootangular.domain.books;

import io.ayounsi.springbootangular.domain.core.repository.Repository;

import java.util.List;

public interface BookRepository extends Repository<Book, Long> {

    int[][] batchInsert(List<Book> books);
}
