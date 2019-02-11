package br.com.caelum.fj36.rest.authors.delete;

import br.com.caelum.fj36.rest.authors.AuthorRepository;
import br.com.caelum.fj36.rest.shared.exceptions.AuthorNotFoundException;
import br.com.caelum.fj36.rest.shared.models.Author;
import org.springframework.stereotype.Service;

@Service
class DeleteAuthorService {

    private final AuthorRepository repository;

    DeleteAuthorService(AuthorRepository repository) {
        this.repository = repository;
    }

    void removeAuthorBy(Long id) {
        Author author = repository.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException(String.format("Cannot find author with %s as id", id)));

        repository.delete(author);
    }
}
