package io.ayounsi.springbootangular.api.reactive.resource;

import io.ayounsi.springbootangular.api.core.dto.BookDto;
import io.ayounsi.springbootangular.domain.books.Book;
import io.ayounsi.springbootangular.domain.commons.model.ReactiveRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@CrossOrigin
@RestController
@RequestMapping("api/v1/books")
public class BookResource {

    private final ReactiveRepository<Book, Long> bookRepository;

    public BookResource(ReactiveRepository<Book, Long> bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public ResponseEntity<Flux<BookDto>> getAll() {
        final Flux<BookDto> books = bookRepository.findAll().map(BookDto::fromBook);

        return ResponseEntity.ok(books);
    }
}


