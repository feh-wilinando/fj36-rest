package br.com.caelum.fj36.rest.authors;

import br.com.caelum.fj36.rest.models.Author;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("authors")
public class AuthorController {

    private final Converter<AuthorDTO, Author> converter;
    private final AuthorRepository repository;

    public AuthorController(Converter<AuthorDTO, Author> converter, AuthorRepository repository) {
        this.converter = converter;
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid AuthorDTO authorDTO) {
        Author author = converter.convert(authorDTO);

        repository.save(author);

        URI uri = UriComponentsBuilder.newInstance().path("/authors/{id}").buildAndExpand(author.getId()).toUri();

        return created(uri).body(author);
    }


    @GetMapping(value = "{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<Author> findById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ok()::body)
                .orElseGet(notFound()::build);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteAuthorById(@PathVariable Long id) {
        Optional<Author> optionalAuthor = repository.findById(id);

        optionalAuthor.ifPresent(repository::delete);

        if (optionalAuthor.isPresent()) {
            return noContent().build();
        }

        return notFound().build();
    }
}
