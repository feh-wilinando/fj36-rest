package br.com.caelum.fj36.rest.books;

import br.com.caelum.fj36.rest.configurations.ErrorResponse;
import br.com.caelum.fj36.rest.shared.exceptions.BookNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice(basePackageClasses = BookExceptionHandler.class)
public class BookExceptionHandler {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<?> productNotFoundHandler(HttpServletRequest request, BookNotFoundException e) {
        System.err.println(e);

        ErrorResponse errorPayload = ErrorResponse.createErrorWith(e.getMessage());

        return new ResponseEntity<>(errorPayload, HttpStatus.NOT_FOUND);
    }
}
