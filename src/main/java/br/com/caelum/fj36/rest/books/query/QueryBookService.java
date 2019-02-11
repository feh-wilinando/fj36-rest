package br.com.caelum.fj36.rest.books.query;

import br.com.caelum.fj36.rest.books.BookRepository;
import br.com.caelum.fj36.rest.books.BookView;
import br.com.caelum.fj36.rest.shared.exceptions.BookNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
class QueryBookService {

    private final BookRepository repository;

    QueryBookService(BookRepository repository) {
        this.repository = repository;
    }

    List<BookView> listAll() {
        return repository.findAll().stream().map(BookView::new).collect(Collectors.toList());
    }

    BookView showBy(Long id) {
        return repository.findById(id)
                .map(BookView::new)
                .orElseThrow(() -> new BookNotFoundException(String.format("Cannot find book with %s as id", id)));
    }
}
