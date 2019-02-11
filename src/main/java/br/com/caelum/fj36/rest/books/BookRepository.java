package br.com.caelum.fj36.rest.books;

import br.com.caelum.fj36.rest.shared.models.Book;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class BookRepository {



    private static final Map<Long, Book> database = new HashMap<>();


    @CacheEvict(cacheNames = "products", allEntries = true)
    public void save(Book book) {
        database.put(book.getId(), book);
    }

    @Cacheable(cacheNames = "products")
    public Optional<Book> findById(Long id) {
        return Optional.ofNullable(database.get(id));
    }

    public void delete(Book book) {
        database.remove(book.getId());
    }

    public List<Book> findAll() {
        return new ArrayList<>(database.values());
    }
}
