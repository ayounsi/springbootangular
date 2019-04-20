package io.ayounsi.springbootangular.api.reactive;

import io.ayounsi.springbootangular.domain.books.Book;
import io.ayounsi.springbootangular.domain.books.BookRepository;
import io.ayounsi.springbootangular.persistence.jpa.EnablePersistenceModule;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

/**
 * Experimental
 */
@SpringBootApplication
@EnablePersistenceModule
public class ApiReactiveApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiReactiveApplication.class, args);
    }

    @Bean
    CommandLineRunner init(BookRepository bookRepository) {
        return args -> {
            Stream.of("Book 1", "Book 2", "Book 3", "Book 4", "Book 5").forEach(title -> {
                Book book = new Book(title);
                bookRepository.save(book);
            });
            bookRepository.findAll().forEach(System.out::println);
        };
    }
}
