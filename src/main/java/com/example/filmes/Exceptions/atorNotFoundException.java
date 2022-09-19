package com.example.filmes.Exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class atorNotFoundException extends ResponseStatusException {
    public atorNotFoundException(String response) {
        super(HttpStatus.NOT_FOUND, response);
    }
}
