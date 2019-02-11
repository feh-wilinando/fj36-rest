package br.com.caelum.fj36.rest.products;

import br.com.caelum.fj36.rest.authors.AuthorController;
import br.com.caelum.fj36.rest.shared.models.Author;
import br.com.caelum.fj36.rest.shared.models.Product;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.http.MediaType;

import java.math.BigDecimal;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class ProductView extends ResourceSupport {
    private final Product product;

    public ProductView(Product product) {
        this.product = product;

        Author author = product.getAuthor();

        Link authorLink = linkTo(methodOn(AuthorController.class).findById(author.getId()))
                .withRel("author")
                .withMedia(MediaType.APPLICATION_JSON_VALUE)
                .withTitle("Show author details")
                .withType("GET");

        Link deleteLink = linkTo(methodOn(ProductController.class).deleteProductById(product.getId()))
                .withRel("remove")
                .withTitle("Remove this product")
                .withType("DELETE");

        Link updateLink = linkTo(ProductController.class).slash(product.getId())
                .withRel("update")
                .withType("PUT")
                .withTitle("Update product info");

        add(authorLink, deleteLink, updateLink);

    }

    public String getIsbn() {
        return product.getIsbn();
    }

    public String getName() {
        return product.getName();
    }

    public BigDecimal getPrice() {
        return product.getPrice();
    }

    @Override
    public Link getId() {
        return linkTo(methodOn(ProductController.class).findById(product.getId()))
                .withSelfRel();
    }
}
