package br.com.caelum.fj36.rest.authors.query;

import br.com.caelum.fj36.rest.authors.AuthorController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@AuthorController
class QueryAuthorController {

    private final QueryAuthorService service;

    QueryAuthorController(QueryAuthorService service) {
        this.service = service;
    }

    @GetMapping(value = "{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    AuthorView findById(@PathVariable Long id) {
        return service.showAuthorBy(id);
    }
}
