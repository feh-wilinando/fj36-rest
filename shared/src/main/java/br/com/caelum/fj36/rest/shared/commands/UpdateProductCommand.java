package br.com.caelum.fj36.rest.shared.commands;

import java.math.BigDecimal;

public interface UpdateProductCommand {
    String getIsbn();

    String getName();

    BigDecimal getPrice();
}
