package br.com.caelum.fj36.rest.books.create;

import br.com.caelum.fj36.rest.books.BookController;
import br.com.caelum.fj36.rest.books.BookInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.net.URI;

import static org.springframework.http.ResponseEntity.created;

@BookController
class CreateBookController {

    private final CreateBookService service;

    CreateBookController(CreateBookService service) {
        this.service = service;
    }

    @PostMapping
    ResponseEntity<?> create(@RequestBody @Valid BookInfo info) {

        URI uri = service.createBookBy(info);

        return created(uri).build();
    }
}
