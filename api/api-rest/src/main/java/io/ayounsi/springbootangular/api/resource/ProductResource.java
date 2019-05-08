package io.ayounsi.springbootangular.api.resource;

import io.ayounsi.springbootangular.api.core.dto.ProductDto;
import io.ayounsi.springbootangular.api.core.dto.ProductMapper;
import io.ayounsi.springbootangular.domain.products.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Api endpoints that expose the Product resource.
 * In this controller we used a mapper to transform our DTOs to Domain Entity.
 */
// We can do this with a filter for all controllers
@CrossOrigin
@RestController
// TODO make this base api url parametrized (A solution is used in the BookResource controller)
@RequestMapping("api/v1")
public class ProductResource {

    private static final String BASE_PATH = "/products";
    private final ProductRepository productRepository;
    private final ProductMapper mapper;

    public ProductResource(ProductRepository productRepository, ProductMapper mapper) {
        this.productRepository = productRepository;
        this.mapper = mapper;
    }

    @GetMapping(BASE_PATH)
    public ResponseEntity<List<ProductDto>> getAll() {
        final List<ProductDto> bookList = productRepository.findAll()
                .stream()
                .map(mapper::fromProduct)
                .collect(Collectors.toList());

        return ResponseEntity.ok(bookList);
    }
}
