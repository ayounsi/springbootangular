package io.ayounsi.springbootangular.domain.books;

import io.ayounsi.springbootangular.domain.core.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = Book.TABLE_NAME)
public class Book extends BaseEntity<Long> {

    public static final String TABLE_NAME = "books";

    private String title;
    private Isbn isbn;

    public Book(String title) {
        this.title = title;
        this.isbn = Isbn.of(123);
    }

    // Needed by hibernate
    protected Book() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Isbn getIsbn() {
        return isbn;
    }

    public void setIsbn(Isbn isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", isbn=" + isbn +
                '}';
    }
}
