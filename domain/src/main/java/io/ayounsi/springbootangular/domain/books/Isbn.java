package io.ayounsi.springbootangular.domain.books;

import java.util.Objects;

public class Isbn {

    private final int value;

    private Isbn(int value) {
        this.value = value;
    }

    public static Isbn of(Integer value) {
        if (value == null) {
            throw new IllegalArgumentException("ISBN value must not be null");
        }
        return new Isbn(value);
    }

    public int intValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Isbn isbn = (Isbn) o;
        return value == isbn.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Isbn{" +
                "value=" + value +
                '}';
    }
}
