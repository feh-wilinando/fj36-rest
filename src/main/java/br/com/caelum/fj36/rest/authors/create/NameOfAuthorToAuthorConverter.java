package br.com.caelum.fj36.rest.authors.create;

import br.com.caelum.fj36.rest.shared.models.Author;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class NameOfAuthorToAuthorConverter implements Converter<NameOfAuthor, Author> {

    @Override
    public Author convert(NameOfAuthor source) {
        String name = source.getName();

        return new Author(name);
    }
}
