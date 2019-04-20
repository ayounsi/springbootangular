package io.ayounsi.springbootangular.api.resource;

import io.ayounsi.springbootangular.api.core.dto.BookDto;
import io.ayounsi.springbootangular.domain.books.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Api endpoints to expose Book resource.
 * In this Controller we implement api base path using place-holder properties strategy.
 * If we adopt this practice, we had to implement a test that enforce our strategy,
 * with checking that all Rest Controllers prefixed with ${api.base-path}.
 */
@RestController
@RequestMapping("${api.base-path}/books")
public class BookResource {

    private final BookRepository bookRepository;

    public BookResource(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> getAll() {
        final List<BookDto> bookList = bookRepository.findAll()
                .stream()
                .map(BookDto::fromBook)
                .collect(Collectors.toList());

        return ResponseEntity.ok(bookList);
    }
}


