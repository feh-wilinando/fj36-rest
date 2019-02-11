package br.com.caelum.fj36.rest.books;

import br.com.caelum.fj36.rest.authors.AuthorRepository;
import br.com.caelum.fj36.rest.shared.exceptions.AuthorNotFoundException;
import br.com.caelum.fj36.rest.shared.models.Author;
import br.com.caelum.fj36.rest.shared.models.Book;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BookInfoToBookConverter implements Converter<BookInfo, Book> {

    private final AuthorRepository repository;

    public BookInfoToBookConverter(AuthorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Book convert(BookInfo source) {
        Long authorId = source.getAuthorId();

        Author author = repository.findById(authorId).orElseThrow(() -> new AuthorNotFoundException(String.format("Not found author with id %s", authorId)));

        return new Book( source.getIsbn(),
                            source.getName(),
                            source.getPrice(),
                            author);
    }

}
