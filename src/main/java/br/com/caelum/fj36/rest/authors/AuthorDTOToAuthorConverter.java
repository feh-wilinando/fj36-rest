package br.com.caelum.fj36.rest.authors;

import br.com.caelum.fj36.rest.models.Author;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AuthorDTOToAuthorConverter implements Converter<AuthorDTO, Author> {

    @Override
    public Author convert(AuthorDTO source) {
        return new Author(source.getName());
    }
}
