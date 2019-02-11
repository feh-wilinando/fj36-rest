package br.com.caelum.fj36.rest.authors.delete;

import br.com.caelum.fj36.rest.authors.AuthorRepository;
import br.com.caelum.fj36.rest.shared.models.Author;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
class DeleteAuthorService {

    private final AuthorRepository repository;

    DeleteAuthorService(AuthorRepository repository) {
        this.repository = repository;
    }

    boolean removeAuthorBy(Long id) {
        Optional<Author> optionalAuthor = repository.findById(id);

        optionalAuthor.ifPresent(repository::delete);

        return optionalAuthor.isPresent();
    }
}
