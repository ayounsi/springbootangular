package io.ayounsi.springbootangular.api;

import io.ayounsi.springbootangular.domain.books.Book;
import io.ayounsi.springbootangular.domain.books.BookRepository;
import io.ayounsi.springbootangular.domain.products.Product;
import io.ayounsi.springbootangular.domain.products.ProductRepository;
import io.ayounsi.springbootangular.persistence.jpa.EnablePersistenceModule;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@EnablePersistenceModule
public class ApiRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiRestApplication.class, args);
    }

    @Bean
    CommandLineRunner init(BookRepository bookRepository, ProductRepository productRepository) {
        return args -> {
            List<Book> books = Stream.of("Book 1", "Book 2", "Book 3", "Book 4", "Book 5")
                    .map(Book::new)
                    .collect(Collectors.toList());
            int[][] ints = bookRepository.batchInsert(books);
            bookRepository.findAll().forEach(System.out::println);
            Stream.of("Product 1", "Product 2", "Product 3", "Product 4", "Product 5").forEach(name -> {
                Product product = new Product(name, name + " description", BigDecimal.TEN);
                productRepository.save(product);
            });
            productRepository.findAll().forEach(System.out::println);
        };
    }
}
