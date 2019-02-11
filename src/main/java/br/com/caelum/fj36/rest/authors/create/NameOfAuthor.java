package br.com.caelum.fj36.rest.authors.create;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NameOfAuthor {

    @NotBlank
    @Size(max = 50)
    private String name;

    /**
     * @deprecated frameworks only
     */
    @Deprecated
    private NameOfAuthor() { }

    public NameOfAuthor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
