package io.ayounsi.springbootangular.persistence.jpa.core;

import io.ayounsi.springbootangular.domain.books.Book;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@NoRepositoryBean
public abstract class AbstractCrudJdbcRepository {

    public static final int BATCH_SIZE = 50000;
    private final JdbcTemplate jdbcTemplate;

    public AbstractCrudJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int[] batchUpdateUsingJdbcTemplate(List<Book> books) {
        return jdbcTemplate.batchUpdate(getInsertQuery(), getBatchPreparedStatementSetter(books));
    }

    @Transactional
    public int[][] batchInsert(List<Book> books) {
        return jdbcTemplate.batchUpdate(
                getInsertQuery(),
                books,
                BATCH_SIZE,
                getPreparedStatement());
    }

    protected abstract ParameterizedPreparedStatementSetter<Book> getPreparedStatement();

    protected abstract String getInsertQuery();

    protected abstract BatchPreparedStatementSetter getBatchPreparedStatementSetter(List<Book> books);
}
