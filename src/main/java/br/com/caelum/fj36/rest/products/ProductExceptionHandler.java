package br.com.caelum.fj36.rest.products;

import br.com.caelum.fj36.rest.configurations.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ProductExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<?> productNotFoundHandler(HttpServletRequest request, ProductNotFoundException e) {
        System.err.println(e);

        ErrorResponse errorPayload = ErrorResponse.createErrorWith(e.getMessage());

        return new ResponseEntity<>(errorPayload, HttpStatus.NOT_FOUND);
    }
}
