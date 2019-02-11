package br.com.caelum.fj36.rest.books;

import br.com.caelum.fj36.rest.shared.models.Author;
import br.com.caelum.fj36.rest.shared.models.Book;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.http.MediaType;

import java.math.BigDecimal;

import static org.springframework.hateoas.mvc.BasicLinkBuilder.linkToCurrentMapping;

public class BookView extends ResourceSupport {
    private final Book book;

    public BookView(Book book) {
        this.book = book;

        Author author = book.getAuthor();

        Link authorLink = linkToCurrentMapping().slash("authors").slash(author.getId())
                .withRel("author")
                .withMedia(MediaType.APPLICATION_JSON_VALUE)
                .withTitle("Show author details")
                .withType("GET");

        Link deleteLink = linkToCurrentMapping().slash("books").slash(book.getId())
                .withRel("remove")
                .withTitle("Remove this book")
                .withType("DELETE");

        Link updateLink = linkToCurrentMapping().slash("books").slash(book.getId())
                .withRel("update")
                .withType("PUT")
                .withTitle("Update book info");

        add(authorLink, deleteLink, updateLink);

    }

    public String getIsbn() {
        return book.getIsbn();
    }

    public String getName() {
        return book.getName();
    }

    public BigDecimal getPrice() {
        return book.getPrice();
    }

    @Override
    public Link getId() {
        return linkToCurrentMapping().slash("books").slash(book.getId())
                .withSelfRel();
    }
}
