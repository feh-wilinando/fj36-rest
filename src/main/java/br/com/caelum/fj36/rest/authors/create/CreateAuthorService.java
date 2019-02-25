package br.com.caelum.fj36.rest.authors.create;

import br.com.caelum.fj36.rest.authors.AuthorRepository;
import br.com.caelum.fj36.rest.shared.models.Author;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
class CreateAuthorService {
    private final Converter<NameOfAuthor, Author> converter;
    private final AuthorRepository repository;
    private final ApplicationEventPublisher publisher;

    CreateAuthorService(Converter<NameOfAuthor, Author> converter, AuthorRepository repository, ApplicationEventPublisher publisher) {
        this.converter = converter;
        this.repository = repository;
        this.publisher = publisher;
    }

    URI saveToAuthorBy(NameOfAuthor authorName) {
        Author author = converter.convert(authorName);

        repository.save(author);

        Thread thread = Thread.currentThread();

        System.out.println("\n\n\n\n");
        System.out.println(String.format("[SERVICE] Thread '%s' with id '%s'", thread.getName(), thread.getId()));
        System.out.println("\n\n\n\n");

        publisher.publishEvent(new CreatedAuthor(author));

        return UriComponentsBuilder.newInstance().path("/authors/{id}").buildAndExpand(author.getId()).toUri();
    }
}
