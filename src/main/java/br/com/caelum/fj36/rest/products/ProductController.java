package br.com.caelum.fj36.rest.products;

import br.com.caelum.fj36.rest.shared.exceptions.ProductNotFoundException;
import br.com.caelum.fj36.rest.shared.models.Author;
import br.com.caelum.fj36.rest.shared.models.Product;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("products")
public class ProductController {

    private final ProductRepository repository;
    private final Converter<ProductInfoDTO, Product> converter;

    public ProductController(ProductRepository repository, Converter<ProductInfoDTO, Product> converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid ProductInfoDTO productDTO) {
        Product product = converter.convert(productDTO);

        repository.save(product);

        URI uri = UriComponentsBuilder.newInstance().path("/products/{id}").buildAndExpand(product.getId()).toUri();

        return created(uri).body(product);
    }

    @GetMapping
    public ResponseEntity<List<ProductView>> list() {
        List<Product> products = repository.findAll();

        if (products.isEmpty()) {
            return notFound().build();
        }

        return ResponseEntity.ok().cacheControl(CacheControl.maxAge(1, TimeUnit.MINUTES))
                .body(products.stream().map(ProductView::new).collect(Collectors.toList()));
    }

    @GetMapping(value = "{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ProductView findById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ProductView::new)
                .orElseThrow(() -> new ProductNotFoundException(String.format("Not found product with %s as id", id)));


    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable Long id) {
        Optional<Product> optionalProduct = repository.findById(id);

        optionalProduct.ifPresent(repository::delete);

        if (optionalProduct.isPresent()) {
            return noContent().build();
        }

        return notFound().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody @Valid ProductInfoDTO productDTO) {

        Optional<Product> optionalProduct = repository.findById(id);

        optionalProduct.ifPresent(product -> product.updateBy(productDTO));

        if (optionalProduct.isPresent()) {
            return noContent().build();
        }

        return notFound().build();
    }

    @GetMapping("{id}/authors")
    public ResponseEntity<Author> showAuthorOfProductId(@PathVariable Long id) {
        Optional<Author> optionalAuthor = repository.findById(id).map(Product::getAuthor);

        if (optionalAuthor.isPresent()) {
            return ok(optionalAuthor.get());
        }

        return notFound().build();
    }
}
