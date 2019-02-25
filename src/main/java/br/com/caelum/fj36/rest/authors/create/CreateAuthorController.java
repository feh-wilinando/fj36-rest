package br.com.caelum.fj36.rest.authors.create;

import static org.springframework.http.ResponseEntity.created;

import br.com.caelum.fj36.rest.authors.AuthorController;
import java.net.URI;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@AuthorController
class CreateAuthorController {

    private final CreateAuthorService service;

    CreateAuthorController(CreateAuthorService service) {
        this.service = service;
    }

    @PostMapping
    ResponseEntity<?> create(@RequestBody @Valid NameOfAuthor authorName) {

        URI uri = service.saveToAuthorBy(authorName);

        return created(uri).build();
    }
}
