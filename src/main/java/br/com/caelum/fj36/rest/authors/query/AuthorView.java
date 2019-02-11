package br.com.caelum.fj36.rest.authors.query;

import br.com.caelum.fj36.rest.shared.models.Author;

class AuthorView {
    private final Author author;

    AuthorView(Author author) {
        this.author = author;
    }

    public Long getId() {
        return author.getId();
    }

    public String getName() {
        return author.getName();
    }
}
