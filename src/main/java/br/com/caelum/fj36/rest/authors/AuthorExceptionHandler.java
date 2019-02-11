package br.com.caelum.fj36.rest.authors;

import br.com.caelum.fj36.rest.configurations.ErrorResponse;
import br.com.caelum.fj36.rest.shared.exceptions.AuthorNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class AuthorExceptionHandler {

    @ExceptionHandler(AuthorNotFoundException.class)
    public ResponseEntity<?> notFound(HttpServletRequest request, AuthorNotFoundException exception) {

        ErrorResponse error = ErrorResponse.createErrorWith(exception.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
