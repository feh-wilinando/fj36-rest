package br.com.caelum.fj36.rest.books.delete;

import br.com.caelum.fj36.rest.books.BookController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static org.springframework.http.ResponseEntity.noContent;

@BookController
class DeleteBookController {

    private final DeleteBookService service;

    DeleteBookController(DeleteBookService service) {
        this.service = service;
    }

    @DeleteMapping("{id}")
    ResponseEntity<?> deleteProductById(@PathVariable Long id) {
        service.deleteBookBy(id);

        return noContent().build();
    }
}
