package br.com.caelum.fj36.rest.books.create;

import br.com.caelum.fj36.rest.books.BookInfo;
import br.com.caelum.fj36.rest.books.BookRepository;
import br.com.caelum.fj36.rest.shared.models.Book;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
class CreateBookService {

    private final BookRepository repository;
    private final Converter<BookInfo, Book> converter;

    CreateBookService(BookRepository repository, Converter<BookInfo, Book> converter) {
        this.repository = repository;
        this.converter = converter;
    }

    URI createBookBy(BookInfo info) {
        Book book = converter.convert(info);

        repository.save(book);

        return UriComponentsBuilder.newInstance().path("/books/{id}").buildAndExpand(book.getId()).toUri();
    }
}
