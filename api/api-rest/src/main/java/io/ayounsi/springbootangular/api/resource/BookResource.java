package io.ayounsi.springbootangular.api.resource;

import io.ayounsi.springbootangular.api.core.dto.BookDto;
import io.ayounsi.springbootangular.domain.books.Book;
import io.ayounsi.springbootangular.domain.books.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static io.ayounsi.springbootangular.api.resource.BookResource.BOOK_RESOURCE_PATH;

/**
 * Api endpoints to expose Book resource.
 * In this Controller we implement api base path using place-holder properties strategy.
 * If we adopt this practice, we had to implement a test that enforce our strategy,
 * with checking that all Rest Controllers prefixed with ${api.base-path}.
 */
@CrossOrigin
@RestController
@RequestMapping(BOOK_RESOURCE_PATH)
public class BookResource {

    public static final String BOOK_RESOURCE_PATH = "${api.base-path}/books";

    private final BookRepository bookRepository;

    public BookResource(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public List<BookDto> getAll() {
        return bookRepository.findAll()
                .stream()
                .map(BookDto::fromBook)
                .collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public Optional<BookDto> getById(@PathVariable Long id) {
        return bookRepository.findById(id)
                .map(BookDto::fromBook);
    }

    /**
     * Todo make sure that the response code is 201 on success (Global config or ResponseEntity instead)
     * <p>
     * Add a new book to the inventory
     *
     * @param newBookDto
     * @return the created Book
     */
    @PostMapping
    public BookDto post(BookDto newBookDto) {
        final Book savedBook = bookRepository.save(newBookDto.toBook());
        return BookDto.fromBook(savedBook);
    }

    /**
     * Todo as the post method, make sure that no content response code is returned
     * <p>
     * Delete a book by id
     *
     * @param id
     */
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }

}


