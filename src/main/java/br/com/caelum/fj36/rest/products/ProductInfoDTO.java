package br.com.caelum.fj36.rest.products;

import br.com.caelum.fj36.rest.shared.commands.UpdateProductInfoCommand;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ProductInfoDTO implements UpdateProductInfoCommand {

    @NotBlank
    private String isbn;

    @NotBlank
    private String name;

    @NotNull
    @DecimalMin("0.0")
    private BigDecimal price;

    @NotNull
    @Min(1)
    private Long authorId;

    /**
     * @deprecated frameworks only
     */
    @Deprecated
    private ProductInfoDTO() { }

    public ProductInfoDTO(String isbn, String name, BigDecimal price, Long authorId) {
        this.isbn = isbn;
        this.name = name;
        this.price = price;
        this.authorId = authorId;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Long getAuthorId() {
        return authorId;
    }
}
