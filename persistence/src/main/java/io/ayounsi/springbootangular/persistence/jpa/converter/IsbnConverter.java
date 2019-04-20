package io.ayounsi.springbootangular.persistence.jpa.converter;

import io.ayounsi.springbootangular.domain.books.Isbn;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * A simple example of a value object integrated with JPA
 */
@Converter(autoApply = true)
public class IsbnConverter implements AttributeConverter<Isbn, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Isbn isbn) {
        if (isbn == null) return null;
        return isbn.intValue();
    }

    @Override
    public Isbn convertToEntityAttribute(Integer dbData) {
        if (dbData == null) return null;
        return Isbn.of(dbData);
    }
}
