package br.com.caelum.fj36.rest.authors.create;

import br.com.caelum.fj36.rest.authors.AuthorRepository;
import br.com.caelum.fj36.rest.shared.models.Author;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
class CreateAuthorService {
    private final Converter<NameOfAuthor, Author> converter;
    private final AuthorRepository repository;

    CreateAuthorService(Converter<NameOfAuthor, Author> converter, AuthorRepository repository) {
        this.converter = converter;
        this.repository = repository;
    }

    URI saveToAuthorBy(NameOfAuthor authorName) {
        Author author = converter.convert(authorName);

        repository.save(author);

        return UriComponentsBuilder.newInstance().path("/authors/{id}").buildAndExpand(author.getId()).toUri();
    }
}
