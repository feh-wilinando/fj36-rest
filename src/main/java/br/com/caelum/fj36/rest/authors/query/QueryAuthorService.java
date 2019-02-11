package br.com.caelum.fj36.rest.authors.query;

import br.com.caelum.fj36.rest.authors.AuthorRepository;
import br.com.caelum.fj36.rest.shared.exceptions.AuthorNotFoundException;
import org.springframework.stereotype.Service;

@Service
class QueryAuthorService {

    private final AuthorRepository repository;

    QueryAuthorService(AuthorRepository repository) {
        this.repository = repository;
    }

    AuthorView showAuthorBy(Long id) {
        return repository.findById(id)
                .map(AuthorView::new)
                .orElseThrow(() -> new AuthorNotFoundException(String.format("Cannot find author with '%s' as id", id)));
    }
}
