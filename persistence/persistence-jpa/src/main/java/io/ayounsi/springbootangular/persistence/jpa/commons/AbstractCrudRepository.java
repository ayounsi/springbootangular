package io.ayounsi.springbootangular.persistence.jpa.commons;

import io.ayounsi.springbootangular.domain.commons.model.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public abstract class AbstractCrudRepository<T, ID, R extends JpaRepository<T, ID>> implements Repository<T, ID> {

    protected final R jpaRepository;

    public AbstractCrudRepository(R jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public T save(T entity) {
        return this.jpaRepository.save(entity);
    }

    @Override
    public List<T> saveAll(List<T> entities) {
        return this.jpaRepository.saveAll(entities);
    }

    @Override
    public Optional<T> findById(ID id) {
        return this.jpaRepository.findById(id);
    }

    @Override
    public boolean existsById(ID id) {
        return this.jpaRepository.existsById(id);
    }

    @Override
    public List<T> findAll() {
        return this.jpaRepository.findAll();
    }

    @Override
    public List<T> findAllById(List<ID> ids) {
        return this.jpaRepository.findAllById(ids);
    }

    @Override
    public long count() {
        return this.jpaRepository.count();
    }

    @Override
    public void deleteById(ID id) {
        this.jpaRepository.deleteById(id);
    }

    @Override
    public void delete(T entity) {
        this.jpaRepository.delete(entity);
    }

    @Override
    public void deleteAll(List<T> entities) {
        this.jpaRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        this.jpaRepository.deleteAll();
    }
}
