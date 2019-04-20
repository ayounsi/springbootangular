package io.ayounsi.springbootangular.api.reactive.resource;

import io.ayounsi.springbootangular.api.core.dto.BookDto;
import io.ayounsi.springbootangular.domain.books.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.stream.Stream;

@RestController
@RequestMapping("api/v1/books")
public class BookResource {

    private final BookRepository bookRepository;

    public BookResource(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public ResponseEntity<Flux<BookDto>> getAll() {
        final Stream<BookDto> bookDtoStream = bookRepository.findAll()
                .stream()
                .map(BookDto::fromBook);

        return ResponseEntity.ok(Flux.fromStream(bookDtoStream));
    }
}


