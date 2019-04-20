package io.ayounsi.springbootangular.domain.books;

import io.ayounsi.springbootangular.domain.commons.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book extends BaseEntity {

    private String title;
    private Isbn isbn;

    public Book(String title) {
        this.title = title;
    }

    // Needed by hibernate
    protected Book() {
    }

    public String getTitle() {
        return title;
    }

    public Isbn getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", isbn=" + isbn +
                '}';
    }
}
