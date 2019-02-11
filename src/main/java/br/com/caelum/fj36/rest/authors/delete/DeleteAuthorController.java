package br.com.caelum.fj36.rest.authors.delete;

import br.com.caelum.fj36.rest.authors.AuthorController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static org.springframework.http.ResponseEntity.noContent;

@AuthorController
class DeleteAuthorController {

    private final DeleteAuthorService service;

    DeleteAuthorController(DeleteAuthorService service) {
        this.service = service;
    }

    @DeleteMapping("{id}")
    ResponseEntity<?> deleteAuthorById(@PathVariable Long id) {

        service.removeAuthorBy(id);

        return noContent().build();
    }
}
