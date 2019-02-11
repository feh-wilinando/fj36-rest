package br.com.caelum.fj36.rest.shared.commands;

import java.math.BigDecimal;

public interface UpdateBasicInfoCommand {
    String getIsbn();

    String getName();

    BigDecimal getPrice();
}
