package br.com.caelum.fj36.rest.authors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AuthorDTO {
    @NotBlank
    @Size(max = 100)
    private String name;

    @Deprecated
    private AuthorDTO() {
    }

    public AuthorDTO(@NotBlank @Size(max = 100) String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
