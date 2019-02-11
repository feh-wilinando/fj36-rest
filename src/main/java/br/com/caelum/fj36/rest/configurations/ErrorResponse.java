package br.com.caelum.fj36.rest.configurations;

public class ErrorResponse {

    private final String[] messages;

    private ErrorResponse(String[] messages) {
        this.messages = messages;
    }

    public static ErrorResponse createErrorWith(String... messages) {
        return new ErrorResponse(messages);
    }
}
