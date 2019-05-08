package io.ayounsi.springbootangular.application.spring.data;

import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Not used !
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
