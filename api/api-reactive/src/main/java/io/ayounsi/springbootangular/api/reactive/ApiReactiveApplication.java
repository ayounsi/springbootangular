package io.ayounsi.springbootangular.api.reactive;

import io.ayounsi.springbootangular.domain.books.Book;
import io.ayounsi.springbootangular.domain.core.repository.ReactiveRepository;
import io.ayounsi.springbootangular.persistence.reactive.EnableReactivePersistenceModule;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Experimental
 */
@SpringBootApplication
// In opposite to security module, persistence module is imported with configuration instead of starter
// Prefer use this way to import business modules and use starter to technical modules
// So, TODO import persistence module with starter
@EnableReactivePersistenceModule
public class ApiReactiveApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiReactiveApplication.class, args);
    }

    @Bean
    CommandLineRunner init(ReactiveRepository<Book, Long> bookRepository) {
        return args -> {
            final List<Book> books = Stream.of(1L, 2L, 3L, 4L, 5L).map(bookId -> {
                Book book = new Book("Book " + bookId);
                book.setId(bookId);
                return book;
            }).collect(Collectors.toList());
            bookRepository.saveAll(books).toStream().forEach(System.out::println);
        };
    }
}
