package io.ayounsi.springbootangular.api.core.dto;

import io.ayounsi.springbootangular.domain.books.Book;

import java.io.Serializable;

public class BookDto implements Serializable {

    private final Integer isbn;
    private final String title;


    private BookDto(Integer isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    public static BookDto fromBook(Book book) {
        final Integer isbn = book.getIsbn() == null ? null : book.getIsbn().intValue();
        return new BookDto(isbn, book.getTitle());
    }

    public Integer getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }
}
