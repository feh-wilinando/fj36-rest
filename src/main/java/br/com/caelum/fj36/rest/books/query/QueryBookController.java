package br.com.caelum.fj36.rest.books.query;

import br.com.caelum.fj36.rest.books.BookController;
import br.com.caelum.fj36.rest.books.BookView;
import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

@BookController
class QueryBookController {

    private final QueryBookService service;

    QueryBookController(QueryBookService service) {
        this.service = service;
    }

    @GetMapping
    ResponseEntity<List<BookView>> list() {
        List<BookView> books = service.listAll();

        if (books.isEmpty()) {
            return notFound().build();
        }

        return ok()
                .cacheControl(CacheControl.maxAge(1, TimeUnit.MINUTES))
                .body(books);
    }

    @GetMapping(value = "{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    BookView findById(@PathVariable Long id) {
        return service.showBy(id);
    }
}
