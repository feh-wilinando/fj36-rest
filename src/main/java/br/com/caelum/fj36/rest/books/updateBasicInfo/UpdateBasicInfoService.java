package br.com.caelum.fj36.rest.books.updateBasicInfo;

import br.com.caelum.fj36.rest.books.BookRepository;
import br.com.caelum.fj36.rest.shared.commands.UpdateBasicInfoCommand;
import br.com.caelum.fj36.rest.shared.exceptions.BookNotFoundException;
import br.com.caelum.fj36.rest.shared.models.Book;
import org.springframework.stereotype.Service;

@Service
class UpdateBasicInfoService {

    private final BookRepository repository;

    UpdateBasicInfoService(BookRepository repository) {
        this.repository = repository;
    }

    void updateBy(Long id, UpdateBasicInfoCommand updateBasicInfo) {
        Book book = repository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(String.format("Cannot find book with %s as id", id)));

        book.updateBy(updateBasicInfo);
    }
}
