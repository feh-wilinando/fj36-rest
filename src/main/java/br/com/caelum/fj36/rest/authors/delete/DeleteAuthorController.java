package br.com.caelum.fj36.rest.authors.delete;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.notFound;

@RestController
@RequestMapping("authors")
class DeleteAuthorController {


    private final DeleteAuthorService service;

    DeleteAuthorController(DeleteAuthorService service) {
        this.service = service;
    }

    @DeleteMapping("{id}")
    ResponseEntity<?> deleteAuthorById(@PathVariable Long id) {

        if (service.removeAuthorBy(id)) {
            return noContent().build();
        }

        return notFound().build();
    }
}
