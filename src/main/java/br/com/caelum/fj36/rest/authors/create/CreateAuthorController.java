package br.com.caelum.fj36.rest.authors.create;

import br.com.caelum.fj36.rest.authors.AuthorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

import static org.springframework.http.ResponseEntity.created;

@RestController
@RequestMapping("authors")
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
