package br.com.caelum.fj36.rest.products;

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

        ClientError errorPayload = new ClientError(e.getMessage());
        return new ResponseEntity<>(errorPayload, HttpStatus.NOT_FOUND);
    }


    static class ClientError {
        private String message;

        public ClientError(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
