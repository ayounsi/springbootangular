package io.ayounsi.springbootangular.persistence.reactive.commons;

import io.ayounsi.springbootangular.domain.core.repository.ReactiveRepository;
import org.reactivestreams.Publisher;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@NoRepositoryBean
public abstract class AbstractReactiveRepository<T, ID, R extends ReactiveCrudRepository<T, ID>> implements ReactiveRepository<T, ID> {

    protected final R reactiveRepository;

    public AbstractReactiveRepository(R reactiveRepository) {
        this.reactiveRepository = reactiveRepository;
    }

    @Override
    public <S extends T> Mono<S> save(S var1) {
        return reactiveRepository.save(var1);
    }

    @Override
    public <S extends T> Flux<S> saveAll(Iterable<S> var1) {
        return reactiveRepository.saveAll(var1);
    }

    @Override
    public <S extends T> Flux<S> saveAll(Publisher<S> var1) {
        return reactiveRepository.saveAll(var1);
    }

    @Override
    public Mono<T> findById(ID var1) {
        return reactiveRepository.findById(var1);
    }

    @Override
    public Mono<T> findById(Publisher<ID> var1) {
        return reactiveRepository.findById(var1);
    }

    @Override
    public Mono<Boolean> existsById(ID var1) {
        return reactiveRepository.existsById(var1);
    }

    @Override
    public Mono<Boolean> existsById(Publisher<ID> var1) {
        return reactiveRepository.existsById(var1);
    }

    @Override
    public Flux<T> findAll() {
        return reactiveRepository.findAll();
    }

    @Override
    public Flux<T> findAllById(Iterable<ID> var1) {
        return reactiveRepository.findAllById(var1);
    }

    @Override
    public Flux<T> findAllById(Publisher<ID> var1) {
        return reactiveRepository.findAllById(var1);
    }

    @Override
    public Mono<Long> count() {
        return reactiveRepository.count();
    }

    @Override
    public Mono<Void> deleteById(ID var1) {
        return reactiveRepository.deleteById(var1);
    }

    @Override
    public Mono<Void> deleteById(Publisher<ID> var1) {
        return reactiveRepository.deleteById(var1);
    }

    @Override
    public Mono<Void> delete(T var1) {
        return reactiveRepository.delete(var1);
    }

    @Override
    public Mono<Void> deleteAll(Iterable<? extends T> var1) {
        return reactiveRepository.deleteAll(var1);
    }

    @Override
    public Mono<Void> deleteAll(Publisher<? extends T> var1) {
        return reactiveRepository.deleteAll(var1);
    }

    @Override
    public Mono<Void> deleteAll() {
        return reactiveRepository.deleteAll();
    }

//
//    @Override
//    public T save(T entity) {
//        return this.reactiveRepository.save(entity).block();
//    }
//
//    @Override
//    public List<T> saveAll(List<T> entities) {
//        return this.reactiveRepository.saveAll(entities).collectList().block();
//    }
//
//    @Override
//    public Optional<T> findById(ID id) {
//        return this.reactiveRepository.findById(id).blockOptional();
//    }
//
//    @Override
//    public boolean existsById(ID id) {
//        return this.reactiveRepository.existsById(id).block();
//    }
//
//    @Override
//    public List<T> findAll() {
//        return this.reactiveRepository.findAll().collectList().block();
//    }
//
//    @Override
//    public List<T> findAllById(List<ID> ids) {
//        return this.reactiveRepository.findAllById(ids).collectList().block();
//    }
//
//    @Override
//    public long count() {
//        return this.reactiveRepository.count().block();
//    }
//
//
//    @Override
//    public void deleteById(ID id) {
//        this.reactiveRepository.deleteById(id).block();
//    }
//
//    @Override
//    public void delete(T entity) {
//        this.reactiveRepository.delete(entity).block();
//    }
//
//    @Override
//    public void deleteAll(List<T> entities) {
//        this.reactiveRepository.deleteAll(entities).block();
//    }
//
//    @Override
//    public void deleteAll() {
//        this.reactiveRepository.deleteAll().block();
//    }
}
