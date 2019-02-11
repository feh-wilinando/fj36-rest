package br.com.caelum.fj36.rest.books.delete;

import br.com.caelum.fj36.rest.books.BookRepository;
import br.com.caelum.fj36.rest.shared.exceptions.BookNotFoundException;
import br.com.caelum.fj36.rest.shared.models.Book;
import org.springframework.stereotype.Service;

@Service
class DeleteBookService {

    private final BookRepository repository;

    DeleteBookService(BookRepository repository) {
        this.repository = repository;
    }

    void deleteBookBy(Long id) {
        Book book = repository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(String.format("Cannot find book with %s as id", id)));

        repository.delete(book);
    }
}
