package br.com.caelum.fj36.rest.authors.create;

import br.com.caelum.fj36.rest.shared.models.Author;
import java.util.StringJoiner;
import org.springframework.context.ApplicationEvent;

class CreatedAuthor {

    private String name;

    CreatedAuthor(Author author) {
        name = author.getName();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CreatedAuthor.class.getSimpleName() + "[", "]")
            .add("name='" + name + "'")
            .toString();
    }
}
