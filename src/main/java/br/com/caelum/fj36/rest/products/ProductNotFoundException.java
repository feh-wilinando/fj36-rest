package br.com.caelum.fj36.rest.products;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(String mesage) {
        super(mesage);
    }

}
