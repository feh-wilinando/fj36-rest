package br.com.caelum.fj36.rest.products;

import br.com.caelum.fj36.rest.models.Author;

import java.math.BigDecimal;

public interface UpdateProductCommand {
    String getIsbn();
    String getName();
    BigDecimal getPrice();
}
