package io.ayounsi.springbootangular.api.core.dto;

import io.ayounsi.springbootangular.domain.books.Book;
import io.ayounsi.springbootangular.domain.books.Isbn;

import java.io.Serializable;

public class BookDto implements Serializable {

    private final Long id;
    private final Integer isbn;
    private final String title;

    private BookDto(Long id, Integer isbn, String title) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
    }

    public static BookDto fromBook(Book book) {
        final Integer isbn = book.getIsbn() == null ? null : book.getIsbn().intValue();
        return new BookDto(book.getId(), isbn, book.getTitle());
    }

    public Book toBook() {
        final Book book = new Book(title);
        book.setIsbn(Isbn.of(isbn));
        return book;
    }

    public Long getId() {
        return id;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }
}
