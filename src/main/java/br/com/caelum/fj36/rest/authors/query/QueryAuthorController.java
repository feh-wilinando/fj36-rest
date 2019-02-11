package br.com.caelum.fj36.rest.authors.query;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("authors")
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
