package io.ayounsi.springbootangular.persistence.jpa.repository.impl;

import io.ayounsi.springbootangular.domain.books.Book;
import io.ayounsi.springbootangular.persistence.jpa.core.AbstractCrudJdbcRepository;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookJdbcRepository extends AbstractCrudJdbcRepository {

    public BookJdbcRepository(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Override
    protected ParameterizedPreparedStatementSetter<Book> getPreparedStatement() {
        return new ParameterizedPreparedStatementSetter<Book>() {
            public void setValues(PreparedStatement ps, Book book)
                    throws SQLException {
                ps.setString(1, book.getTitle());
                ps.setInt(2, book.getIsbn().intValue());
            }
        };
    }

    @Override
    protected String getInsertQuery() {
        return String.format("INSERT INTO %s (title, isbn) VALUES (?, ?)", Book.TABLE_NAME);
    }

    @Override
    protected BatchPreparedStatementSetter getBatchPreparedStatementSetter(List<Book> books) {
        return new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, books.get(i).getTitle());
                ps.setInt(2, books.get(i).getIsbn().intValue());
            }

            @Override
            public int getBatchSize() {
                return 1;
            }
        };
    }
}
