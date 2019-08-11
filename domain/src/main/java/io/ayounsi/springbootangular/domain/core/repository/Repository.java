package io.ayounsi.springbootangular.domain.core.repository;

import java.util.List;
import java.util.Optional;

public interface Repository<T, ID> {

    T save(T entity);

    List<T> saveAll(List<T> entities);

    Optional<T> findById(ID id);

    boolean existsById(ID id);

    List<T> findAll();

    List<T> findAll(PageParam page);

    List<T> findAll(SortParam sort);

    List<T> findAll(PageParam page, SortParam sort);

    List<T> findAllById(List<ID> ids);

    long count();

    void deleteById(ID id);

    void delete(T entity);

    void deleteAll(List<T> entities);

    void deleteAll();

}
