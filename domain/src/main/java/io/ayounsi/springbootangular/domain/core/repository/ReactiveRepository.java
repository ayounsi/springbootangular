package io.ayounsi.springbootangular.domain.core.repository;

import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * TODO do i use CompletableFuture instead of Spring reactor for reactive support in the domain ?
 * Or maybe move this responsibility to the application layer to support the reactive use cases.
 *
 * @param <T>
 * @param <ID>
 */
public interface ReactiveRepository<T, ID> {
    <S extends T> Mono<S> save(S var1);

    <S extends T> Flux<S> saveAll(Iterable<S> var1);

    <S extends T> Flux<S> saveAll(Publisher<S> var1);

    Mono<T> findById(ID var1);

    Mono<T> findById(Publisher<ID> var1);

    Mono<Boolean> existsById(ID var1);

    Mono<Boolean> existsById(Publisher<ID> var1);

    Flux<T> findAll();

    Flux<T> findAllById(Iterable<ID> var1);

    Flux<T> findAllById(Publisher<ID> var1);

    Mono<Long> count();

    Mono<Void> deleteById(ID var1);

    Mono<Void> deleteById(Publisher<ID> var1);

    Mono<Void> delete(T var1);

    Mono<Void> deleteAll(Iterable<? extends T> var1);

    Mono<Void> deleteAll(Publisher<? extends T> var1);

    Mono<Void> deleteAll();
}
