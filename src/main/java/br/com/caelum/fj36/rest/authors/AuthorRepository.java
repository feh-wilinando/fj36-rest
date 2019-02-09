package br.com.caelum.fj36.rest.authors;

import br.com.caelum.fj36.rest.models.Author;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class AuthorRepository {

    private static final Map<Long, Author> database = new HashMap<>();

    public void save(Author author) {
        database.put(author.getId(), author);
    }

    public Optional<Author> findById(Long id) {
        return Optional.ofNullable(database.get(id));
    }

    public void delete(Author author) {
        database.remove(author.getId());
    }
}
